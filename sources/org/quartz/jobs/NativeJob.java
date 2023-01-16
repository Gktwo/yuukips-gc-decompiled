package org.quartz.jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/jobs/NativeJob.class */
public class NativeJob implements Job {
    private final Logger log = LoggerFactory.getLogger(getClass());
    public static final String PROP_COMMAND = "command";
    public static final String PROP_PARAMETERS = "parameters";
    public static final String PROP_WAIT_FOR_PROCESS = "waitForProcess";
    public static final String PROP_CONSUME_STREAMS = "consumeStreams";

    @Override // org.quartz.Job
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data = context.getMergedJobDataMap();
        String command = data.getString(PROP_COMMAND);
        String parameters = data.getString(PROP_PARAMETERS);
        if (parameters == null) {
            parameters = "";
        }
        boolean wait = true;
        if (data.containsKey(PROP_WAIT_FOR_PROCESS)) {
            wait = data.getBooleanValue(PROP_WAIT_FOR_PROCESS);
        }
        boolean consumeStreams = false;
        if (data.containsKey(PROP_CONSUME_STREAMS)) {
            consumeStreams = data.getBooleanValue(PROP_CONSUME_STREAMS);
        }
        context.setResult(runNativeCommand(command, parameters, wait, consumeStreams));
    }

    protected Logger getLog() {
        return this.log;
    }

    private Integer runNativeCommand(String command, String parameters, boolean wait, boolean consumeStreams) throws JobExecutionException {
        String[] cmd;
        Integer result = null;
        String[] args = {command, parameters};
        try {
            String osName = System.getProperty("os.name");
            if (osName.startsWith("Windows")) {
                cmd = new String[args.length + 2];
                if (osName.equals("Windows 95")) {
                    cmd[0] = "command.com";
                } else {
                    cmd[0] = "cmd.exe";
                }
                cmd[1] = "/C";
                System.arraycopy(args, 0, cmd, 2, args.length);
            } else {
                cmd = osName.equals("Linux") ? new String[]{"/bin/sh", "-c", args[0] + " " + args[1]} : args;
            }
            Runtime rt = Runtime.getRuntime();
            getLog().info("About to run " + cmd[0] + " " + cmd[1] + " " + (cmd.length > 2 ? cmd[2] : "") + " ...");
            Process proc = rt.exec(cmd);
            StreamConsumer stdoutConsumer = new StreamConsumer(proc.getInputStream(), "stdout");
            if (consumeStreams) {
                StreamConsumer stderrConsumer = new StreamConsumer(proc.getErrorStream(), "stderr");
                stdoutConsumer.start();
                stderrConsumer.start();
            }
            if (wait) {
                result = Integer.valueOf(proc.waitFor());
            }
            return result;
        } catch (Throwable x) {
            throw new JobExecutionException("Error launching native command: ", x, false);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/quartz/jobs/NativeJob$StreamConsumer.class */
    public class StreamConsumer extends Thread {

        /* renamed from: is */
        InputStream f3373is;
        String type;

        public StreamConsumer(InputStream inputStream, String type) {
            this.f3373is = inputStream;
            this.type = type;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader br;
            try {
                br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(this.f3373is));
                    while (true) {
                        String line = br.readLine();
                        if (line == null) {
                            break;
                        } else if (this.type.equalsIgnoreCase("stderr")) {
                            NativeJob.this.getLog().warn(this.type + ">" + line);
                        } else {
                            NativeJob.this.getLog().info(this.type + ">" + line);
                        }
                    }
                    if (br != null) {
                        try {
                            br.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (IOException ioe) {
                    NativeJob.this.getLog().error("Error consuming " + this.type + " stream of spawned process.", (Throwable) ioe);
                    if (br != null) {
                        try {
                            br.close();
                        } catch (Exception e2) {
                        }
                    }
                }
            } catch (Throwable th) {
                if (br != null) {
                    try {
                        br.close();
                    } catch (Exception e3) {
                    }
                }
                throw th;
            }
        }
    }
}
