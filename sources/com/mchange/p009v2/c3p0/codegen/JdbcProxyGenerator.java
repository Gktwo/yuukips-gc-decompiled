package com.mchange.p009v2.c3p0.codegen;

import com.mchange.p009v2.c3p0.C3P0ProxyConnection;
import com.mchange.p009v2.c3p0.C3P0ProxyStatement;
import com.mchange.p009v2.c3p0.impl.ProxyResultSetDetachable;
import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import com.mchange.p009v2.codegen.intfc.DelegatorGenerator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/* renamed from: com.mchange.v2.c3p0.codegen.JdbcProxyGenerator */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/JdbcProxyGenerator.class */
public abstract class JdbcProxyGenerator extends DelegatorGenerator {
    private static final boolean PREMATURE_DETACH_DEBUG = false;

    abstract String getInnerTypeName();

    JdbcProxyGenerator() {
        setGenerateInnerSetter(false);
        setGenerateInnerGetter(false);
        setGenerateNoArgConstructor(false);
        setGenerateWrappingConstructor(true);
        setClassModifiers(17);
        setMethodModifiers(17);
        setWrappingConstructorModifiers(0);
    }

    /* renamed from: com.mchange.v2.c3p0.codegen.JdbcProxyGenerator$NewProxyMetaDataGenerator */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/JdbcProxyGenerator$NewProxyMetaDataGenerator.class */
    static final class NewProxyMetaDataGenerator extends JdbcProxyGenerator {
        NewProxyMetaDataGenerator() {
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator
        String getInnerTypeName() {
            return "DatabaseMetaData";
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            String mname = method.getName();
            if (JdbcProxyGenerator.jdbc4WrapperMethod(mname)) {
                JdbcProxyGenerator.generateWrapperDelegateCode(intfcl, genclass, method, iw);
            } else if (ResultSet.class.isAssignableFrom(method.getReturnType())) {
                iw.println("ResultSet innerResultSet = inner." + CodegenUtils.methodCall(method) + ";");
                iw.println("if (innerResultSet == null) return null;");
                iw.println("return new NewProxyResultSet( innerResultSet, parentPooledConnection, inner, this );");
            } else if (mname.equals("getConnection")) {
                iw.println("return this.proxyCon;");
            } else {
                generateDelegateCode(intfcl, genclass, method, iw);
            }
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generatePreDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            if (method.getExceptionTypes().length > 0) {
                generatePreDelegateCode(intfcl, genclass, method, iw);
            }
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generatePostDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            if (method.getExceptionTypes().length > 0) {
                generatePostDelegateCode(intfcl, genclass, method, iw);
            }
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateExtraDeclarations(Class intfcl, String genclass, IndentedWriter iw) throws IOException {
            generateExtraDeclarations(intfcl, genclass, iw);
            iw.println();
            iw.println("NewProxyConnection proxyCon;");
            iw.println();
            iw.print(CodegenUtils.fqcnLastElement(genclass));
            iw.println("( " + CodegenUtils.simpleClassName(intfcl) + " inner, NewPooledConnection parentPooledConnection, NewProxyConnection proxyCon )");
            iw.println("{");
            iw.upIndent();
            iw.println("this( inner, parentPooledConnection );");
            iw.println("this.proxyCon = proxyCon;");
            iw.downIndent();
            iw.println("}");
        }
    }

    /* renamed from: com.mchange.v2.c3p0.codegen.JdbcProxyGenerator$NewProxyResultSetGenerator */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/JdbcProxyGenerator$NewProxyResultSetGenerator.class */
    static final class NewProxyResultSetGenerator extends JdbcProxyGenerator {
        NewProxyResultSetGenerator() {
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator
        String getInnerTypeName() {
            return "ResultSet";
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            String mname = method.getName();
            if (JdbcProxyGenerator.jdbc4WrapperMethod(mname)) {
                JdbcProxyGenerator.generateWrapperDelegateCode(intfcl, genclass, method, iw);
                return;
            }
            method.getReturnType();
            iw.println("if (proxyConn != null) proxyConn.maybeDirtyTransaction();");
            iw.println();
            if (mname.equals("close")) {
                iw.println("if (! this.isDetached())");
                iw.println("{");
                iw.upIndent();
                iw.println("if (creator instanceof Statement)");
                iw.upIndent();
                iw.println("parentPooledConnection.markInactiveResultSetForStatement( (Statement) creator, inner );");
                iw.downIndent();
                iw.println("else if (creator instanceof DatabaseMetaData)");
                iw.upIndent();
                iw.println("parentPooledConnection.markInactiveMetaDataResultSet( inner );");
                iw.downIndent();
                iw.println("else if (creator instanceof Connection)");
                iw.upIndent();
                iw.println("parentPooledConnection.markInactiveRawConnectionResultSet( inner );");
                iw.downIndent();
                iw.println("else throw new InternalError(\"Must be Statement or DatabaseMetaData -- Bad Creator: \" + creator);");
                iw.println("if (creatorProxy instanceof ProxyResultSetDetachable) ((ProxyResultSetDetachable) creatorProxy).detachProxyResultSet( this );");
                iw.println("this.detach();");
                iw.println("inner.close();");
                iw.println("this.inner = null;");
                iw.downIndent();
                iw.println("}");
            } else if (mname.equals("getStatement")) {
                iw.println("if (creator instanceof Statement)");
                iw.upIndent();
                iw.println("return (Statement) creatorProxy;");
                iw.downIndent();
                iw.println("else if (creator instanceof DatabaseMetaData)");
                iw.upIndent();
                iw.println("return null;");
                iw.downIndent();
                iw.println("else throw new InternalError(\"Must be Statement or DatabaseMetaData -- Bad Creator: \" + creator);");
            } else if (mname.equals("isClosed")) {
                iw.println("return this.isDetached();");
            } else {
                generateDelegateCode(intfcl, genclass, method, iw);
            }
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateExtraDeclarations(Class intfcl, String genclass, IndentedWriter iw) throws IOException {
            generateExtraDeclarations(intfcl, genclass, iw);
            iw.println();
            iw.println("Object creator;");
            iw.println("Object creatorProxy;");
            iw.println("NewProxyConnection proxyConn;");
            iw.println();
            iw.print(CodegenUtils.fqcnLastElement(genclass));
            iw.println("( " + CodegenUtils.simpleClassName(intfcl) + " inner, NewPooledConnection parentPooledConnection, Object c, Object cProxy )");
            iw.println("{");
            iw.upIndent();
            iw.println("this( inner, parentPooledConnection );");
            iw.println("this.creator      = c;");
            iw.println("this.creatorProxy = cProxy;");
            iw.println("if (creatorProxy instanceof NewProxyConnection) this.proxyConn = (NewProxyConnection) cProxy;");
            iw.downIndent();
            iw.println("}");
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generatePreDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            generatePreDelegateCode(intfcl, genclass, method, iw);
        }
    }

    /* renamed from: com.mchange.v2.c3p0.codegen.JdbcProxyGenerator$NewProxyAnyStatementGenerator */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/JdbcProxyGenerator$NewProxyAnyStatementGenerator.class */
    static final class NewProxyAnyStatementGenerator extends JdbcProxyGenerator {
        private static final boolean CONCURRENT_ACCESS_DEBUG = false;

        NewProxyAnyStatementGenerator() {
            setExtraInterfaces(new Class[]{C3P0ProxyStatement.class, ProxyResultSetDetachable.class});
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator
        String getInnerTypeName() {
            return "Statement";
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            String mname = method.getName();
            if (JdbcProxyGenerator.jdbc4WrapperMethod(mname)) {
                JdbcProxyGenerator.generateWrapperDelegateCode(intfcl, genclass, method, iw);
                return;
            }
            Class retType = method.getReturnType();
            iw.println("maybeDirtyTransaction();");
            iw.println();
            if (ResultSet.class.isAssignableFrom(retType)) {
                iw.println("ResultSet innerResultSet = inner." + CodegenUtils.methodCall(method) + ";");
                iw.println("if (innerResultSet == null) return null;");
                iw.println("parentPooledConnection.markActiveResultSetForStatement( inner, innerResultSet );");
                iw.println("NewProxyResultSet out = new NewProxyResultSet( innerResultSet, parentPooledConnection, inner, this );");
                iw.println("synchronized ( myProxyResultSets ) { myProxyResultSets.add( out ); }");
                iw.println("return out;");
            } else if (mname.equals("getConnection")) {
                iw.println("if (! this.isDetached())");
                iw.upIndent();
                iw.println("return creatorProxy;");
                iw.downIndent();
                iw.println("else");
                iw.upIndent();
                iw.println("throw new SQLException(\"You cannot operate on a closed Statement!\");");
                iw.downIndent();
            } else if (mname.equals("close")) {
                iw.println("if (! this.isDetached())");
                iw.println("{");
                iw.upIndent();
                iw.println("synchronized ( myProxyResultSets )");
                iw.println("{");
                iw.upIndent();
                iw.println("for( Iterator ii = myProxyResultSets.iterator(); ii.hasNext(); )");
                iw.println("{");
                iw.upIndent();
                iw.println("ResultSet closeMe = (ResultSet) ii.next();");
                iw.println("ii.remove();");
                iw.println();
                iw.println("try { closeMe.close(); }");
                iw.println("catch (SQLException e)");
                iw.println("{");
                iw.upIndent();
                iw.println("if (logger.isLoggable( MLevel.WARNING ))");
                iw.upIndent();
                iw.println("logger.log( MLevel.WARNING, \"Exception on close of apparently orphaned ResultSet.\", e);");
                iw.downIndent();
                iw.downIndent();
                iw.println("}");
                iw.println("if (logger.isLoggable( MLevel.FINE ))");
                iw.upIndent();
                iw.println("logger.log( MLevel.FINE, this + \" closed orphaned ResultSet: \" +closeMe);");
                iw.downIndent();
                iw.downIndent();
                iw.println("}");
                iw.downIndent();
                iw.println("}");
                iw.println();
                iw.println("if ( is_cached )");
                iw.upIndent();
                iw.println("parentPooledConnection.checkinStatement( inner );");
                iw.downIndent();
                iw.println("else");
                iw.println("{");
                iw.upIndent();
                iw.println("parentPooledConnection.markInactiveUncachedStatement( inner );");
                iw.println("try{ inner.close(); }");
                iw.println("catch (Exception e )");
                iw.println("{");
                iw.upIndent();
                iw.println("if (logger.isLoggable( MLevel.WARNING ))");
                iw.upIndent();
                iw.println("logger.log( MLevel.WARNING, \"Exception on close of inner statement.\", e);");
                iw.downIndent();
                iw.println("SQLException sqle = SqlUtils.toSQLException( e );");
                iw.println("throw sqle;");
                iw.downIndent();
                iw.println("}");
                iw.downIndent();
                iw.println("}");
                iw.println();
                iw.println("this.detach();");
                iw.println("this.inner = null;");
                iw.println("this.creatorProxy = null;");
                iw.downIndent();
                iw.println("}");
            } else if (mname.equals("isClosed")) {
                iw.println("return this.isDetached();");
            } else {
                generateDelegateCode(intfcl, genclass, method, iw);
            }
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generatePreDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            generatePreDelegateCode(intfcl, genclass, method, iw);
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generatePostDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            generatePostDelegateCode(intfcl, genclass, method, iw);
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateExtraDeclarations(Class intfcl, String genclass, IndentedWriter iw) throws IOException {
            generateExtraDeclarations(intfcl, genclass, iw);
            iw.println();
            iw.println("boolean is_cached;");
            iw.println("NewProxyConnection creatorProxy;");
            iw.println();
            iw.println("// Although formally unnecessary, we sync access to myProxyResultSets on");
            iw.println("// that set's own lock, in case clients (illegally but not uncommonly) close()");
            iw.println("// the Statement from a Thread other than the one they use in general");
            iw.println("// with the Statement");
            iw.println("HashSet myProxyResultSets = new HashSet();");
            iw.println();
            iw.println("public void detachProxyResultSet( ResultSet prs )");
            iw.println("{");
            iw.upIndent();
            iw.println("synchronized (myProxyResultSets) { myProxyResultSets.remove( prs ); }");
            iw.downIndent();
            iw.println("}");
            iw.println();
            iw.print(CodegenUtils.fqcnLastElement(genclass));
            iw.println("( " + CodegenUtils.simpleClassName(intfcl) + " inner, NewPooledConnection parentPooledConnection, boolean cached, NewProxyConnection cProxy )");
            iw.println("{");
            iw.upIndent();
            iw.println("this( inner, parentPooledConnection );");
            iw.println("this.is_cached = cached;");
            iw.println("this.creatorProxy = cProxy;");
            iw.downIndent();
            iw.println("}");
            iw.println();
            iw.println("public Object rawStatementOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException");
            iw.println("{");
            iw.upIndent();
            iw.println("maybeDirtyTransaction();");
            iw.println();
            iw.println("if (target == C3P0ProxyStatement.RAW_STATEMENT) target = inner;");
            iw.println("for (int i = 0, len = args.length; i < len; ++i)");
            iw.upIndent();
            iw.println("if (args[i] == C3P0ProxyStatement.RAW_STATEMENT) args[i] = inner;");
            iw.downIndent();
            iw.println("Object out = m.invoke(target, args);");
            iw.println("if (out instanceof ResultSet)");
            iw.println("{");
            iw.upIndent();
            iw.println("ResultSet innerResultSet = (ResultSet) out;");
            iw.println("parentPooledConnection.markActiveResultSetForStatement( inner, innerResultSet );");
            iw.println("out = new NewProxyResultSet( innerResultSet, parentPooledConnection, inner, this );");
            iw.downIndent();
            iw.println("}");
            iw.println();
            iw.println("return out;");
            iw.downIndent();
            iw.println("}");
            iw.println();
            iw.println("void maybeDirtyTransaction()");
            iw.println("{ if (creatorProxy != null) creatorProxy.maybeDirtyTransaction(); }");
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateExtraImports(IndentedWriter iw) throws IOException {
            generateExtraImports(iw);
            iw.println("import java.lang.reflect.InvocationTargetException;");
            iw.println("import java.util.HashSet;");
            iw.println("import java.util.Iterator;");
        }
    }

    /* renamed from: com.mchange.v2.c3p0.codegen.JdbcProxyGenerator$NewProxyConnectionGenerator */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/JdbcProxyGenerator$NewProxyConnectionGenerator.class */
    static final class NewProxyConnectionGenerator extends JdbcProxyGenerator {
        NewProxyConnectionGenerator() {
            setMethodModifiers(33);
            setExtraInterfaces(new Class[]{C3P0ProxyConnection.class});
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator
        String getInnerTypeName() {
            return "Connection";
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            String mname = method.getName();
            if (JdbcProxyGenerator.jdbc4WrapperMethod(mname)) {
                JdbcProxyGenerator.generateWrapperDelegateCode(intfcl, genclass, method, iw);
            } else if (mname.equals("createStatement")) {
                iw.println("txn_known_resolved = false;");
                iw.println();
                iw.println("Statement innerStmt = inner." + CodegenUtils.methodCall(method) + ";");
                iw.println("parentPooledConnection.markActiveUncachedStatement( innerStmt );");
                iw.println("return new NewProxyStatement( innerStmt, parentPooledConnection, false, this );");
            } else if (mname.equals("prepareStatement")) {
                iw.println("txn_known_resolved = false;");
                iw.println();
                iw.println("PreparedStatement innerStmt;");
                iw.println();
                iw.println("if ( parentPooledConnection.isStatementCaching() )");
                iw.println("{");
                iw.upIndent();
                iw.println("try");
                iw.println("{");
                iw.upIndent();
                generateFindMethodAndArgs(method, iw);
                iw.println("innerStmt = (PreparedStatement) parentPooledConnection.checkoutStatement( method, args );");
                iw.println("return new NewProxyPreparedStatement( innerStmt, parentPooledConnection, true, this );");
                iw.downIndent();
                iw.println("}");
                iw.println("catch (ResourceClosedException e)");
                iw.println("{");
                iw.upIndent();
                iw.println("if ( logger.isLoggable( MLevel.FINE ) )");
                iw.upIndent();
                iw.println("logger.log( MLevel.FINE, \"A Connection tried to prepare a Statement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.\", e );");
                iw.downIndent();
                iw.println("innerStmt = inner." + CodegenUtils.methodCall(method) + ";");
                iw.println("parentPooledConnection.markActiveUncachedStatement( innerStmt );");
                iw.println("return new NewProxyPreparedStatement( innerStmt, parentPooledConnection, false, this );");
                iw.downIndent();
                iw.println("}");
                iw.downIndent();
                iw.println("}");
                iw.println("else");
                iw.println("{");
                iw.upIndent();
                iw.println("innerStmt = inner." + CodegenUtils.methodCall(method) + ";");
                iw.println("parentPooledConnection.markActiveUncachedStatement( innerStmt );");
                iw.println("return new NewProxyPreparedStatement( innerStmt, parentPooledConnection, false, this );");
                iw.downIndent();
                iw.println("}");
            } else if (mname.equals("prepareCall")) {
                iw.println("txn_known_resolved = false;");
                iw.println();
                iw.println("CallableStatement innerStmt;");
                iw.println();
                iw.println("if ( parentPooledConnection.isStatementCaching() )");
                iw.println("{");
                iw.upIndent();
                iw.println("try");
                iw.println("{");
                iw.upIndent();
                generateFindMethodAndArgs(method, iw);
                iw.println("innerStmt = (CallableStatement) parentPooledConnection.checkoutStatement( method, args );");
                iw.println("return new NewProxyCallableStatement( innerStmt, parentPooledConnection, true, this );");
                iw.downIndent();
                iw.println("}");
                iw.println("catch (ResourceClosedException e)");
                iw.println("{");
                iw.upIndent();
                iw.println("if ( logger.isLoggable( MLevel.FINE ) )");
                iw.upIndent();
                iw.println("logger.log( MLevel.FINE, \"A Connection tried to prepare a CallableStatement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.\", e );");
                iw.downIndent();
                iw.println("innerStmt = inner." + CodegenUtils.methodCall(method) + ";");
                iw.println("parentPooledConnection.markActiveUncachedStatement( innerStmt );");
                iw.println("return new NewProxyCallableStatement( innerStmt, parentPooledConnection, false, this );");
                iw.downIndent();
                iw.println("}");
                iw.downIndent();
                iw.println("}");
                iw.println("else");
                iw.println("{");
                iw.upIndent();
                iw.println("innerStmt = inner." + CodegenUtils.methodCall(method) + ";");
                iw.println("parentPooledConnection.markActiveUncachedStatement( innerStmt );");
                iw.println("return new NewProxyCallableStatement( innerStmt, parentPooledConnection, false, this );");
                iw.downIndent();
                iw.println("}");
            } else if (mname.equals("getMetaData")) {
                iw.println("txn_known_resolved = false;");
                iw.println();
                iw.println("if (this.metaData == null)");
                iw.println("{");
                iw.upIndent();
                iw.println("DatabaseMetaData innerMetaData = inner." + CodegenUtils.methodCall(method) + ";");
                iw.println("this.metaData = new NewProxyDatabaseMetaData( innerMetaData, parentPooledConnection, this );");
                iw.downIndent();
                iw.println("}");
                iw.println("return this.metaData;");
            } else if (mname.equals("setTransactionIsolation")) {
                generateDelegateCode(intfcl, genclass, method, iw);
                iw.println("parentPooledConnection.markNewTxnIsolation( " + CodegenUtils.generatedArgumentName(0) + " );");
            } else if (mname.equals("setCatalog")) {
                generateDelegateCode(intfcl, genclass, method, iw);
                iw.println("parentPooledConnection.markNewCatalog( " + CodegenUtils.generatedArgumentName(0) + " );");
            } else if (mname.equals("setHoldability")) {
                generateDelegateCode(intfcl, genclass, method, iw);
                iw.println("parentPooledConnection.markNewHoldability( " + CodegenUtils.generatedArgumentName(0) + " );");
            } else if (mname.equals("setReadOnly")) {
                generateDelegateCode(intfcl, genclass, method, iw);
                iw.println("parentPooledConnection.markNewReadOnly( " + CodegenUtils.generatedArgumentName(0) + " );");
            } else if (mname.equals("setTypeMap")) {
                generateDelegateCode(intfcl, genclass, method, iw);
                iw.println("parentPooledConnection.markNewTypeMap( " + CodegenUtils.generatedArgumentName(0) + " );");
            } else if (mname.equals("getWarnings") || mname.equals("clearWarnings")) {
                generateDelegateCode(intfcl, genclass, method, iw);
            } else if (mname.equals("close")) {
                iw.println("if (! this.isDetached())");
                iw.println("{");
                iw.upIndent();
                iw.println("NewPooledConnection npc = parentPooledConnection;");
                iw.println("this.detach();");
                iw.println("npc.markClosedProxyConnection( this, txn_known_resolved );");
                iw.println("this.inner = null;");
                iw.downIndent();
                iw.println("}");
                iw.println("else if (Debug.DEBUG && logger.isLoggable( MLevel.FINE ))");
                iw.println("{");
                iw.upIndent();
                iw.println("logger.log( MLevel.FINE, this + \": close() called more than once.\" );");
                iw.downIndent();
                iw.println("}");
            } else if (mname.equals("isClosed")) {
                iw.println("return this.isDetached();");
            } else if (mname.equals("isValid")) {
                iw.println("if (this.isDetached()) return false;");
                generateDelegateCode(intfcl, genclass, method, iw);
            } else {
                boolean known_resolved = mname.equals("commit") || mname.equals("rollback") || mname.equals("setAutoCommit");
                if (!known_resolved) {
                    iw.println("txn_known_resolved = false;");
                    iw.println();
                }
                generateDelegateCode(intfcl, genclass, method, iw);
                if (known_resolved) {
                    iw.println();
                    iw.println("txn_known_resolved = true;");
                }
            }
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateExtraDeclarations(Class intfcl, String genclass, IndentedWriter iw) throws IOException {
            iw.println("boolean txn_known_resolved = true;");
            iw.println();
            iw.println("DatabaseMetaData metaData = null;");
            iw.println();
            iw.println("public Object rawConnectionOperation(Method m, Object target, Object[] args)");
            iw.upIndent();
            iw.println("throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException");
            iw.downIndent();
            iw.println("{");
            iw.upIndent();
            iw.println("maybeDirtyTransaction();");
            iw.println();
            iw.println("if (inner == null)");
            iw.upIndent();
            iw.println("throw new SQLException(\"You cannot operate on a closed Connection!\");");
            iw.downIndent();
            iw.println("if ( target == C3P0ProxyConnection.RAW_CONNECTION)");
            iw.upIndent();
            iw.println("target = inner;");
            iw.downIndent();
            iw.println("for (int i = 0, len = args.length; i < len; ++i)");
            iw.upIndent();
            iw.println("if (args[i] == C3P0ProxyConnection.RAW_CONNECTION)");
            iw.upIndent();
            iw.println("args[i] = inner;");
            iw.downIndent();
            iw.downIndent();
            iw.println("Object out = m.invoke( target, args );");
            iw.println();
            iw.println("// we never cache Statements generated by an operation on the raw Connection");
            iw.println("if (out instanceof CallableStatement)");
            iw.println("{");
            iw.upIndent();
            iw.println("CallableStatement innerStmt = (CallableStatement) out;");
            iw.println("parentPooledConnection.markActiveUncachedStatement( innerStmt );");
            iw.println("out = new NewProxyCallableStatement( innerStmt, parentPooledConnection, false, this );");
            iw.downIndent();
            iw.println("}");
            iw.println("else if (out instanceof PreparedStatement)");
            iw.println("{");
            iw.upIndent();
            iw.println("PreparedStatement innerStmt = (PreparedStatement) out;");
            iw.println("parentPooledConnection.markActiveUncachedStatement( innerStmt );");
            iw.println("out = new NewProxyPreparedStatement( innerStmt, parentPooledConnection, false, this );");
            iw.downIndent();
            iw.println("}");
            iw.println("else if (out instanceof Statement)");
            iw.println("{");
            iw.upIndent();
            iw.println("Statement innerStmt = (Statement) out;");
            iw.println("parentPooledConnection.markActiveUncachedStatement( innerStmt );");
            iw.println("out = new NewProxyStatement( innerStmt, parentPooledConnection, false, this );");
            iw.downIndent();
            iw.println("}");
            iw.println("else if (out instanceof ResultSet)");
            iw.println("{");
            iw.upIndent();
            iw.println("ResultSet innerRs = (ResultSet) out;");
            iw.println("parentPooledConnection.markActiveRawConnectionResultSet( innerRs );");
            iw.println("out = new NewProxyResultSet( innerRs, parentPooledConnection, inner, this );");
            iw.downIndent();
            iw.println("}");
            iw.println("else if (out instanceof DatabaseMetaData)");
            iw.upIndent();
            iw.println("out = new NewProxyDatabaseMetaData( (DatabaseMetaData) out, parentPooledConnection );");
            iw.downIndent();
            iw.println("return out;");
            iw.downIndent();
            iw.println("}");
            iw.println();
            iw.println("synchronized void maybeDirtyTransaction()");
            iw.println("{ txn_known_resolved = false; }");
            generateExtraDeclarations(intfcl, genclass, iw);
        }

        void generateFindMethodAndArgs(Method method, IndentedWriter iw) throws IOException {
            iw.println("Class[] argTypes = ");
            iw.println("{");
            iw.upIndent();
            Class[] argTypes = method.getParameterTypes();
            int len = argTypes.length;
            for (int i = 0; i < len; i++) {
                if (i != 0) {
                    iw.println(",");
                }
                iw.print(CodegenUtils.simpleClassName(argTypes[i]) + ".class");
            }
            iw.println();
            iw.downIndent();
            iw.println("};");
            iw.println("Method method = Connection.class.getMethod( \"" + method.getName() + "\" , argTypes );");
            iw.println();
            iw.println("Object[] args = ");
            iw.println("{");
            iw.upIndent();
            int len2 = argTypes.length;
            for (int i2 = 0; i2 < len2; i2++) {
                if (i2 != 0) {
                    iw.println(",");
                }
                String argName = CodegenUtils.generatedArgumentName(i2);
                Class argType = argTypes[i2];
                if (!argType.isPrimitive()) {
                    iw.print(argName);
                } else if (argType == Boolean.TYPE) {
                    iw.print("Boolean.valueOf( " + argName + " )");
                } else if (argType == Byte.TYPE) {
                    iw.print("new Byte( " + argName + " )");
                } else if (argType == Character.TYPE) {
                    iw.print("new Character( " + argName + " )");
                } else if (argType == Short.TYPE) {
                    iw.print("new Short( " + argName + " )");
                } else if (argType == Integer.TYPE) {
                    iw.print("new Integer( " + argName + " )");
                } else if (argType == Long.TYPE) {
                    iw.print("new Long( " + argName + " )");
                } else if (argType == Float.TYPE) {
                    iw.print("new Float( " + argName + " )");
                } else if (argType == Double.TYPE) {
                    iw.print("new Double( " + argName + " )");
                }
            }
            iw.downIndent();
            iw.println("};");
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generateExtraImports(IndentedWriter iw) throws IOException {
            generateExtraImports(iw);
            iw.println("import java.lang.reflect.InvocationTargetException;");
            iw.println("import com.mchange.v2.util.ResourceClosedException;");
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generatePreDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            if ("setClientInfo".equals(method.getName())) {
                iw.println("try");
                iw.println("{");
                iw.upIndent();
                generatePreDelegateCode(intfcl, genclass, method, iw);
                return;
            }
            generatePreDelegateCode(intfcl, genclass, method, iw);
        }

        @Override // com.mchange.p009v2.c3p0.codegen.JdbcProxyGenerator, com.mchange.p009v2.codegen.intfc.DelegatorGenerator
        protected void generatePostDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
            if ("setClientInfo".equals(method.getName())) {
                generatePostDelegateCode(intfcl, genclass, method, iw);
                iw.downIndent();
                iw.println("}");
                iw.println("catch (Exception e)");
                iw.println("{ throw SqlUtils.toSQLClientInfoException( e ); }");
                return;
            }
            generatePostDelegateCode(intfcl, genclass, method, iw);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.mchange.p009v2.codegen.intfc.DelegatorGenerator
    public void generateDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
        generateDelegateCode(intfcl, genclass, method, iw);
    }

    @Override // com.mchange.p009v2.codegen.intfc.DelegatorGenerator
    protected void generatePreDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
        if (!jdbc4WrapperMethod(method.getName())) {
            generateTryOpener(iw);
        }
    }

    @Override // com.mchange.p009v2.codegen.intfc.DelegatorGenerator
    protected void generatePostDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
        if (!jdbc4WrapperMethod(method.getName())) {
            generateTryCloserAndCatch(intfcl, genclass, method, iw);
        }
    }

    void generateTryOpener(IndentedWriter iw) throws IOException {
        iw.println("try");
        iw.println("{");
        iw.upIndent();
    }

    void generateTryCloserAndCatch(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
        iw.downIndent();
        iw.println("}");
        iw.println("catch (NullPointerException exc)");
        iw.println("{");
        iw.upIndent();
        iw.println("if ( this.isDetached() )");
        iw.println("{");
        iw.upIndent();
        if ("close".equals(method.getName())) {
            iw.println("if (Debug.DEBUG && logger.isLoggable( MLevel.FINE ))");
            iw.println("{");
            iw.upIndent();
            iw.println("logger.log( MLevel.FINE, this + \": close() called more than once.\" );");
            iw.downIndent();
            iw.println("}");
        } else {
            iw.println("throw SqlUtils.toSQLException(\"You can't operate on a closed " + getInnerTypeName() + "!!!\", exc);");
        }
        iw.downIndent();
        iw.println("}");
        iw.println("else throw exc;");
        iw.downIndent();
        iw.println("}");
        iw.println("catch (Exception exc)");
        iw.println("{");
        iw.upIndent();
        iw.println("if (! this.isDetached())");
        iw.println("{");
        iw.upIndent();
        iw.println("throw parentPooledConnection.handleThrowable( exc );");
        iw.downIndent();
        iw.println("}");
        iw.println("else throw SqlUtils.toSQLException( exc );");
        iw.downIndent();
        iw.println("}");
    }

    @Override // com.mchange.p009v2.codegen.intfc.DelegatorGenerator
    protected void generateExtraDeclarations(Class intfcl, String genclass, IndentedWriter iw) throws IOException {
        iw.println("private final static MLogger logger = MLog.getLogger( \"" + genclass + "\" );");
        iw.println();
        iw.println("volatile NewPooledConnection parentPooledConnection;");
        iw.println();
        iw.println("ConnectionEventListener cel = new ConnectionEventListener()");
        iw.println("{");
        iw.upIndent();
        iw.println("public void connectionErrorOccurred(ConnectionEvent evt)");
        iw.println("{ /* DON'T detach()... IGNORE -- this could be an ordinary error. Leave it to the PooledConnection to test, but leave proxies intact */ }");
        iw.println();
        iw.println("public void connectionClosed(ConnectionEvent evt)");
        iw.println("{ detach(); }");
        iw.downIndent();
        iw.println("};");
        iw.println();
        iw.println("void attach( NewPooledConnection parentPooledConnection )");
        iw.println("{");
        iw.upIndent();
        iw.println("this.parentPooledConnection = parentPooledConnection;");
        iw.println("parentPooledConnection.addConnectionEventListener( cel );");
        iw.downIndent();
        iw.println("}");
        iw.println();
        iw.println("private void detach()");
        iw.println("{");
        iw.upIndent();
        writeDetachBody(iw);
        iw.downIndent();
        iw.println("}");
        iw.println();
        iw.print(CodegenUtils.fqcnLastElement(genclass));
        iw.println("( " + CodegenUtils.simpleClassName(intfcl) + " inner, NewPooledConnection parentPooledConnection )");
        iw.println("{");
        iw.upIndent();
        iw.println("this( inner );");
        iw.println("attach( parentPooledConnection );");
        generateExtraConstructorCode(intfcl, genclass, iw);
        iw.downIndent();
        iw.println("}");
        iw.println();
        iw.println("boolean isDetached()");
        iw.println("{ return (this.parentPooledConnection == null); }");
        iw.println();
        iw.println("public String toString() { return super.toString() + \" [wrapping: \" + inner + \"]\"; }");
        iw.println();
        generateIsWrapperHelperMethods(intfcl, iw);
    }

    protected void writeDetachBody(IndentedWriter iw) throws IOException {
        iw.println("parentPooledConnection.removeConnectionEventListener( cel );");
        iw.println("parentPooledConnection = null;");
    }

    @Override // com.mchange.p009v2.codegen.intfc.DelegatorGenerator
    protected void generateExtraImports(IndentedWriter iw) throws IOException {
        iw.println("import java.sql.*;");
        iw.println("import javax.sql.*;");
        iw.println("import com.mchange.v2.log.*;");
        iw.println("import java.lang.reflect.Method;");
        iw.println("import com.mchange.v2.sql.SqlUtils;");
    }

    void generateExtraConstructorCode(Class intfcl, String genclass, IndentedWriter iw) throws IOException {
    }

    private static void generateIsWrapperHelperMethods(Class intfcl, IndentedWriter iw) throws IOException {
        iw.println("// helper methods for unwrap( ... ), isWrapperFor( ... )");
        iw.println("private boolean isWrapperForInner( Class intfcl )");
        iw.println("{ return ( " + intfcl.getName() + ".class == intfcl || intfcl.isAssignableFrom( inner.getClass() ) ); }");
        iw.println();
        iw.println("private boolean isWrapperForThis( Class intfcl )");
        iw.println("{ return intfcl.isAssignableFrom( this.getClass() ); }");
    }

    /* access modifiers changed from: private */
    public static void generateWrapperDelegateCode(Class intfcl, String genclass, Method method, IndentedWriter iw) throws IOException {
        String mname = method.getName();
        if ("isWrapperFor".equals(mname)) {
            iw.println("return ( isWrapperForInner( a ) || isWrapperForThis( a ) );");
        } else if ("unwrap".equals(mname)) {
            iw.println("if (this.isWrapperForInner( a )) return inner.unwrap( a );");
            iw.println("if (this.isWrapperForThis( a )) return this;");
            iw.println("else throw new SQLException( this + \" is not a wrapper for or implementation of \" + a.getName());");
        }
    }

    /* access modifiers changed from: private */
    public static boolean jdbc4WrapperMethod(String mname) {
        return "unwrap".equals(mname) || "isWrapperFor".equals(mname);
    }

    public static void main(String[] argv) {
        try {
            if (argv.length != 1) {
                System.err.println("java " + JdbcProxyGenerator.class.getName() + " <source-root-directory>");
                return;
            }
            File srcroot = new File(argv[0]);
            if (!srcroot.exists() || !srcroot.canWrite()) {
                System.err.println(JdbcProxyGenerator.class.getName() + " -- sourceroot: " + argv[0] + " must exist and be writable");
                return;
            }
            DelegatorGenerator mdgen = new NewProxyMetaDataGenerator();
            DelegatorGenerator rsgen = new NewProxyResultSetGenerator();
            DelegatorGenerator stgen = new NewProxyAnyStatementGenerator();
            genclass(new NewProxyConnectionGenerator(), Connection.class, "com.mchange.v2.c3p0.impl.NewProxyConnection", srcroot);
            genclass(stgen, Statement.class, "com.mchange.v2.c3p0.impl.NewProxyStatement", srcroot);
            genclass(stgen, PreparedStatement.class, "com.mchange.v2.c3p0.impl.NewProxyPreparedStatement", srcroot);
            genclass(stgen, CallableStatement.class, "com.mchange.v2.c3p0.impl.NewProxyCallableStatement", srcroot);
            genclass(rsgen, ResultSet.class, "com.mchange.v2.c3p0.impl.NewProxyResultSet", srcroot);
            genclass(mdgen, DatabaseMetaData.class, "com.mchange.v2.c3p0.impl.NewProxyDatabaseMetaData", srcroot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void genclass(DelegatorGenerator dg, Class intfcl, String fqcn, File srcroot) throws IOException {
        File genDir = new File(srcroot, dirForFqcn(fqcn));
        if (!genDir.exists()) {
            System.err.println(JdbcProxyGenerator.class.getName() + " -- creating directory: " + genDir.getAbsolutePath());
            genDir.mkdirs();
        }
        String fileName = CodegenUtils.fqcnLastElement(fqcn) + ".java";
        Writer w = null;
        try {
            w = new BufferedWriter(new FileWriter(new File(genDir, fileName)));
            dg.writeDelegator(intfcl, fqcn, w);
            w.flush();
            System.err.println("Generated " + fileName);
            if (w != null) {
                try {
                    w.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (w != null) {
                try {
                    w.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    static String dirForFqcn(String fqcn) {
        StringBuffer sb = new StringBuffer(fqcn.substring(0, fqcn.lastIndexOf(46) + 1));
        int len = sb.length();
        for (int i = 0; i < len; i++) {
            if (sb.charAt(i) == '.') {
                sb.setCharAt(i, '/');
            }
        }
        return sb.toString();
    }
}
