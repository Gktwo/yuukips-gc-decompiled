package org.jline.utils;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javassist.compiler.TokenId;
import kotlin.text.Typography;
import org.eclipse.jetty.http.HttpStatus;
import org.jline.console.Printer;
import org.jline.reader.impl.LineReaderImpl;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/InfoCmp.class */
public final class InfoCmp {
    private static final Map<String, Object> CAPS = new HashMap();

    static {
        for (String s : Arrays.asList("dumb", "dumb-color", "ansi", "xterm", "xterm-256color", "windows", "windows-256color", "windows-conemu", "windows-vtp", "screen", "screen-256color", "rxvt-unicode", "rxvt-unicode-256color", "rxvt-basic", "rxvt")) {
            setDefaultInfoCmp(s, () -> {
                return loadDefaultInfoCmp(s);
            });
        }
    }

    private InfoCmp() {
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: grasscutter.jar:org/jline/utils/InfoCmp$Capability.class */
    public static final class Capability extends Enum<Capability> {
        public static final Capability auto_left_margin = new Capability("auto_left_margin", 0);
        public static final Capability auto_right_margin = new Capability("auto_right_margin", 1);
        public static final Capability back_color_erase = new Capability("back_color_erase", 2);
        public static final Capability can_change = new Capability("can_change", 3);
        public static final Capability ceol_standout_glitch = new Capability("ceol_standout_glitch", 4);
        public static final Capability col_addr_glitch = new Capability("col_addr_glitch", 5);
        public static final Capability cpi_changes_res = new Capability("cpi_changes_res", 6);
        public static final Capability cr_cancels_micro_mode = new Capability("cr_cancels_micro_mode", 7);
        public static final Capability dest_tabs_magic_smso = new Capability("dest_tabs_magic_smso", 8);
        public static final Capability eat_newline_glitch = new Capability("eat_newline_glitch", 9);
        public static final Capability erase_overstrike = new Capability("erase_overstrike", 10);
        public static final Capability generic_type = new Capability("generic_type", 11);
        public static final Capability hard_copy = new Capability("hard_copy", 12);
        public static final Capability hard_cursor = new Capability("hard_cursor", 13);
        public static final Capability has_meta_key = new Capability("has_meta_key", 14);
        public static final Capability has_print_wheel = new Capability("has_print_wheel", 15);
        public static final Capability has_status_line = new Capability("has_status_line", 16);
        public static final Capability hue_lightness_saturation = new Capability("hue_lightness_saturation", 17);
        public static final Capability insert_null_glitch = new Capability("insert_null_glitch", 18);
        public static final Capability lpi_changes_res = new Capability("lpi_changes_res", 19);
        public static final Capability memory_above = new Capability("memory_above", 20);
        public static final Capability memory_below = new Capability("memory_below", 21);
        public static final Capability move_insert_mode = new Capability("move_insert_mode", 22);
        public static final Capability move_standout_mode = new Capability("move_standout_mode", 23);
        public static final Capability needs_xon_xoff = new Capability("needs_xon_xoff", 24);
        public static final Capability no_esc_ctlc = new Capability("no_esc_ctlc", 25);
        public static final Capability no_pad_char = new Capability("no_pad_char", 26);
        public static final Capability non_dest_scroll_region = new Capability("non_dest_scroll_region", 27);
        public static final Capability non_rev_rmcup = new Capability("non_rev_rmcup", 28);
        public static final Capability over_strike = new Capability("over_strike", 29);
        public static final Capability prtr_silent = new Capability("prtr_silent", 30);
        public static final Capability row_addr_glitch = new Capability("row_addr_glitch", 31);
        public static final Capability semi_auto_right_margin = new Capability("semi_auto_right_margin", 32);
        public static final Capability status_line_esc_ok = new Capability("status_line_esc_ok", 33);
        public static final Capability tilde_glitch = new Capability("tilde_glitch", 34);
        public static final Capability transparent_underline = new Capability("transparent_underline", 35);
        public static final Capability xon_xoff = new Capability("xon_xoff", 36);
        public static final Capability columns = new Capability(Printer.COLUMNS, 37);
        public static final Capability init_tabs = new Capability("init_tabs", 38);
        public static final Capability label_height = new Capability("label_height", 39);
        public static final Capability label_width = new Capability("label_width", 40);
        public static final Capability lines = new Capability("lines", 41);
        public static final Capability lines_of_memory = new Capability("lines_of_memory", 42);
        public static final Capability magic_cookie_glitch = new Capability("magic_cookie_glitch", 43);
        public static final Capability max_attributes = new Capability("max_attributes", 44);
        public static final Capability max_colors = new Capability("max_colors", 45);
        public static final Capability max_pairs = new Capability("max_pairs", 46);
        public static final Capability maximum_windows = new Capability("maximum_windows", 47);
        public static final Capability no_color_video = new Capability("no_color_video", 48);
        public static final Capability num_labels = new Capability("num_labels", 49);
        public static final Capability padding_baud_rate = new Capability("padding_baud_rate", 50);
        public static final Capability virtual_terminal = new Capability("virtual_terminal", 51);
        public static final Capability width_status_line = new Capability("width_status_line", 52);
        public static final Capability bit_image_entwining = new Capability("bit_image_entwining", 53);
        public static final Capability bit_image_type = new Capability("bit_image_type", 54);
        public static final Capability buffer_capacity = new Capability("buffer_capacity", 55);
        public static final Capability buttons = new Capability("buttons", 56);
        public static final Capability dot_horz_spacing = new Capability("dot_horz_spacing", 57);
        public static final Capability dot_vert_spacing = new Capability("dot_vert_spacing", 58);
        public static final Capability max_micro_address = new Capability("max_micro_address", 59);
        public static final Capability max_micro_jump = new Capability("max_micro_jump", 60);
        public static final Capability micro_col_size = new Capability("micro_col_size", 61);
        public static final Capability micro_line_size = new Capability("micro_line_size", 62);
        public static final Capability number_of_pins = new Capability("number_of_pins", 63);
        public static final Capability output_res_char = new Capability("output_res_char", 64);
        public static final Capability output_res_horz_inch = new Capability("output_res_horz_inch", 65);
        public static final Capability output_res_line = new Capability("output_res_line", 66);
        public static final Capability output_res_vert_inch = new Capability("output_res_vert_inch", 67);
        public static final Capability print_rate = new Capability("print_rate", 68);
        public static final Capability wide_char_size = new Capability("wide_char_size", 69);
        public static final Capability acs_chars = new Capability("acs_chars", 70);
        public static final Capability back_tab = new Capability("back_tab", 71);
        public static final Capability bell = new Capability("bell", 72);
        public static final Capability carriage_return = new Capability("carriage_return", 73);
        public static final Capability change_char_pitch = new Capability("change_char_pitch", 74);
        public static final Capability change_line_pitch = new Capability("change_line_pitch", 75);
        public static final Capability change_res_horz = new Capability("change_res_horz", 76);
        public static final Capability change_res_vert = new Capability("change_res_vert", 77);
        public static final Capability change_scroll_region = new Capability("change_scroll_region", 78);
        public static final Capability char_padding = new Capability("char_padding", 79);
        public static final Capability clear_all_tabs = new Capability("clear_all_tabs", 80);
        public static final Capability clear_margins = new Capability("clear_margins", 81);
        public static final Capability clear_screen = new Capability("clear_screen", 82);
        public static final Capability clr_bol = new Capability("clr_bol", 83);
        public static final Capability clr_eol = new Capability("clr_eol", 84);
        public static final Capability clr_eos = new Capability("clr_eos", 85);
        public static final Capability column_address = new Capability("column_address", 86);
        public static final Capability command_character = new Capability("command_character", 87);
        public static final Capability create_window = new Capability("create_window", 88);
        public static final Capability cursor_address = new Capability("cursor_address", 89);
        public static final Capability cursor_down = new Capability("cursor_down", 90);
        public static final Capability cursor_home = new Capability("cursor_home", 91);
        public static final Capability cursor_invisible = new Capability("cursor_invisible", 92);
        public static final Capability cursor_left = new Capability("cursor_left", 93);
        public static final Capability cursor_mem_address = new Capability("cursor_mem_address", 94);
        public static final Capability cursor_normal = new Capability("cursor_normal", 95);
        public static final Capability cursor_right = new Capability("cursor_right", 96);
        public static final Capability cursor_to_ll = new Capability("cursor_to_ll", 97);
        public static final Capability cursor_up = new Capability("cursor_up", 98);
        public static final Capability cursor_visible = new Capability("cursor_visible", 99);
        public static final Capability define_char = new Capability("define_char", 100);
        public static final Capability delete_character = new Capability("delete_character", 101);
        public static final Capability delete_line = new Capability("delete_line", 102);
        public static final Capability dial_phone = new Capability("dial_phone", 103);
        public static final Capability dis_status_line = new Capability("dis_status_line", 104);
        public static final Capability display_clock = new Capability("display_clock", 105);
        public static final Capability down_half_line = new Capability("down_half_line", 106);
        public static final Capability ena_acs = new Capability("ena_acs", 107);
        public static final Capability enter_alt_charset_mode = new Capability("enter_alt_charset_mode", 108);
        public static final Capability enter_am_mode = new Capability("enter_am_mode", 109);
        public static final Capability enter_blink_mode = new Capability("enter_blink_mode", 110);
        public static final Capability enter_bold_mode = new Capability("enter_bold_mode", 111);
        public static final Capability enter_ca_mode = new Capability("enter_ca_mode", 112);
        public static final Capability enter_delete_mode = new Capability("enter_delete_mode", 113);
        public static final Capability enter_dim_mode = new Capability("enter_dim_mode", 114);
        public static final Capability enter_doublewide_mode = new Capability("enter_doublewide_mode", 115);
        public static final Capability enter_draft_quality = new Capability("enter_draft_quality", 116);
        public static final Capability enter_insert_mode = new Capability("enter_insert_mode", 117);
        public static final Capability enter_italics_mode = new Capability("enter_italics_mode", 118);
        public static final Capability enter_leftward_mode = new Capability("enter_leftward_mode", 119);
        public static final Capability enter_micro_mode = new Capability("enter_micro_mode", 120);
        public static final Capability enter_near_letter_quality = new Capability("enter_near_letter_quality", 121);
        public static final Capability enter_normal_quality = new Capability("enter_normal_quality", 122);
        public static final Capability enter_protected_mode = new Capability("enter_protected_mode", 123);
        public static final Capability enter_reverse_mode = new Capability("enter_reverse_mode", 124);
        public static final Capability enter_secure_mode = new Capability("enter_secure_mode", 125);
        public static final Capability enter_shadow_mode = new Capability("enter_shadow_mode", 126);
        public static final Capability enter_standout_mode = new Capability("enter_standout_mode", 127);
        public static final Capability enter_subscript_mode = new Capability("enter_subscript_mode", 128);
        public static final Capability enter_superscript_mode = new Capability("enter_superscript_mode", 129);
        public static final Capability enter_underline_mode = new Capability("enter_underline_mode", 130);
        public static final Capability enter_upward_mode = new Capability("enter_upward_mode", 131);
        public static final Capability enter_xon_mode = new Capability("enter_xon_mode", 132);
        public static final Capability erase_chars = new Capability("erase_chars", 133);
        public static final Capability exit_alt_charset_mode = new Capability("exit_alt_charset_mode", 134);
        public static final Capability exit_am_mode = new Capability("exit_am_mode", 135);
        public static final Capability exit_attribute_mode = new Capability("exit_attribute_mode", 136);
        public static final Capability exit_ca_mode = new Capability("exit_ca_mode", 137);
        public static final Capability exit_delete_mode = new Capability("exit_delete_mode", 138);
        public static final Capability exit_doublewide_mode = new Capability("exit_doublewide_mode", 139);
        public static final Capability exit_insert_mode = new Capability("exit_insert_mode", 140);
        public static final Capability exit_italics_mode = new Capability("exit_italics_mode", 141);
        public static final Capability exit_leftward_mode = new Capability("exit_leftward_mode", 142);
        public static final Capability exit_micro_mode = new Capability("exit_micro_mode", 143);
        public static final Capability exit_shadow_mode = new Capability("exit_shadow_mode", 144);
        public static final Capability exit_standout_mode = new Capability("exit_standout_mode", 145);
        public static final Capability exit_subscript_mode = new Capability("exit_subscript_mode", 146);
        public static final Capability exit_superscript_mode = new Capability("exit_superscript_mode", 147);
        public static final Capability exit_underline_mode = new Capability("exit_underline_mode", 148);
        public static final Capability exit_upward_mode = new Capability("exit_upward_mode", 149);
        public static final Capability exit_xon_mode = new Capability("exit_xon_mode", 150);
        public static final Capability fixed_pause = new Capability("fixed_pause", 151);
        public static final Capability flash_hook = new Capability("flash_hook", 152);
        public static final Capability flash_screen = new Capability("flash_screen", 153);
        public static final Capability form_feed = new Capability("form_feed", 154);
        public static final Capability from_status_line = new Capability("from_status_line", 155);
        public static final Capability goto_window = new Capability("goto_window", 156);
        public static final Capability hangup = new Capability("hangup", 157);
        public static final Capability init_1string = new Capability("init_1string", 158);
        public static final Capability init_2string = new Capability("init_2string", 159);
        public static final Capability init_3string = new Capability("init_3string", 160);
        public static final Capability init_file = new Capability("init_file", 161);
        public static final Capability init_prog = new Capability("init_prog", 162);
        public static final Capability initialize_color = new Capability("initialize_color", 163);
        public static final Capability initialize_pair = new Capability("initialize_pair", 164);
        public static final Capability insert_character = new Capability("insert_character", 165);
        public static final Capability insert_line = new Capability("insert_line", 166);
        public static final Capability insert_padding = new Capability("insert_padding", 167);
        public static final Capability key_a1 = new Capability("key_a1", 168);
        public static final Capability key_a3 = new Capability("key_a3", 169);
        public static final Capability key_b2 = new Capability("key_b2", 170);
        public static final Capability key_backspace = new Capability("key_backspace", 171);
        public static final Capability key_beg = new Capability("key_beg", 172);
        public static final Capability key_btab = new Capability("key_btab", 173);
        public static final Capability key_c1 = new Capability("key_c1", 174);
        public static final Capability key_c3 = new Capability("key_c3", 175);
        public static final Capability key_cancel = new Capability("key_cancel", 176);
        public static final Capability key_catab = new Capability("key_catab", 177);
        public static final Capability key_clear = new Capability("key_clear", 178);
        public static final Capability key_close = new Capability("key_close", 179);
        public static final Capability key_command = new Capability("key_command", 180);
        public static final Capability key_copy = new Capability("key_copy", 181);
        public static final Capability key_create = new Capability("key_create", 182);
        public static final Capability key_ctab = new Capability("key_ctab", 183);
        public static final Capability key_dc = new Capability("key_dc", 184);
        public static final Capability key_dl = new Capability("key_dl", 185);
        public static final Capability key_down = new Capability("key_down", 186);
        public static final Capability key_eic = new Capability("key_eic", 187);
        public static final Capability key_end = new Capability("key_end", 188);
        public static final Capability key_enter = new Capability("key_enter", 189);
        public static final Capability key_eol = new Capability("key_eol", 190);
        public static final Capability key_eos = new Capability("key_eos", 191);
        public static final Capability key_exit = new Capability("key_exit", 192);
        public static final Capability key_f0 = new Capability("key_f0", 193);
        public static final Capability key_f1 = new Capability("key_f1", 194);
        public static final Capability key_f10 = new Capability("key_f10", 195);
        public static final Capability key_f11 = new Capability("key_f11", 196);
        public static final Capability key_f12 = new Capability("key_f12", 197);
        public static final Capability key_f13 = new Capability("key_f13", 198);
        public static final Capability key_f14 = new Capability("key_f14", 199);
        public static final Capability key_f15 = new Capability("key_f15", 200);
        public static final Capability key_f16 = new Capability("key_f16", 201);
        public static final Capability key_f17 = new Capability("key_f17", 202);
        public static final Capability key_f18 = new Capability("key_f18", 203);
        public static final Capability key_f19 = new Capability("key_f19", 204);
        public static final Capability key_f2 = new Capability("key_f2", 205);
        public static final Capability key_f20 = new Capability("key_f20", 206);
        public static final Capability key_f21 = new Capability("key_f21", 207);
        public static final Capability key_f22 = new Capability("key_f22", PacketOpcodes.SetSceneWeatherAreaReq);
        public static final Capability key_f23 = new Capability("key_f23", PacketOpcodes.ExecuteGadgetLuaRsp);
        public static final Capability key_f24 = new Capability("key_f24", PacketOpcodes.ExecuteGadgetLuaReq);
        public static final Capability key_f25 = new Capability("key_f25", PacketOpcodes.PlatformChangeRouteNotify);
        public static final Capability key_f26 = new Capability("key_f26", PacketOpcodes.PlayerEnterSceneInfoNotify);
        public static final Capability key_f27 = new Capability("key_f27", PacketOpcodes.GetScenePointRsp);
        public static final Capability key_f28 = new Capability("key_f28", PacketOpcodes.SceneAvatarStaminaStepReq);
        public static final Capability key_f29 = new Capability("key_f29", Typography.times);
        public static final Capability key_f3 = new Capability("key_f3", 216);
        public static final Capability key_f30 = new Capability("key_f30", PacketOpcodes.CutSceneBeginNotify);
        public static final Capability key_f31 = new Capability("key_f31", PacketOpcodes.SceneEntityDrownReq);
        public static final Capability key_f32 = new Capability("key_f32", PacketOpcodes.WorldPlayerReviveReq);
        public static final Capability key_f33 = new Capability("key_f33", PacketOpcodes.SceneInitFinishRsp);
        public static final Capability key_f34 = new Capability("key_f34", 221);
        public static final Capability key_f35 = new Capability("key_f35", PacketOpcodes.SceneDestroyEntityReq);
        public static final Capability key_f36 = new Capability("key_f36", PacketOpcodes.UnmarkEntityInMinMapNotify);
        public static final Capability key_f37 = new Capability("key_f37", PacketOpcodes.SceneAvatarStaminaStepRsp);
        public static final Capability key_f38 = new Capability("key_f38", PacketOpcodes.GetSceneAreaRsp);
        public static final Capability key_f39 = new Capability("key_f39", PacketOpcodes.SealBattleProgressNotify);
        public static final Capability key_f4 = new Capability("key_f4", PacketOpcodes.EndCameraSceneLookNotify);
        public static final Capability key_f40 = new Capability("key_f40", PacketOpcodes.SceneCreateEntityReq);
        public static final Capability key_f41 = new Capability("key_f41", PacketOpcodes.SceneEntityMoveNotify);
        public static final Capability key_f42 = new Capability("key_f42", PacketOpcodes.EntityForceSyncReq);
        public static final Capability key_f43 = new Capability("key_f43", PacketOpcodes.BackMyWorldReq);
        public static final Capability key_f44 = new Capability("key_f44", PacketOpcodes.SceneTimeNotify);
        public static final Capability key_f45 = new Capability("key_f45", PacketOpcodes.EnterSceneReadyRsp);
        public static final Capability key_f46 = new Capability("key_f46", PacketOpcodes.JoinPlayerSceneReq);
        public static final Capability key_f47 = new Capability("key_f47", 235);
        public static final Capability key_f48 = new Capability("key_f48", PacketOpcodes.EnterSceneWeatherAreaNotify);
        public static final Capability key_f49 = new Capability("key_f49", PacketOpcodes.PlatformStartRouteNotify);
        public static final Capability key_f5 = new Capability("key_f5", 238);
        public static final Capability key_f50 = new Capability("key_f50", PacketOpcodes.ScenePointUnlockNotify);
        public static final Capability key_f51 = new Capability("key_f51", PacketOpcodes.SceneKickPlayerRsp);
        public static final Capability key_f52 = new Capability("key_f52", PacketOpcodes.SceneEntitiesMovesReq);
        public static final Capability key_f53 = new Capability("key_f53", PacketOpcodes.EnterWorldAreaReq);
        public static final Capability key_f54 = new Capability("key_f54", PacketOpcodes.EntityForceSyncRsp);
        public static final Capability key_f55 = new Capability("key_f55", PacketOpcodes.AllSeenMonsterNotify);
        public static final Capability key_f56 = new Capability("key_f56", PacketOpcodes.SceneDestroyEntityRsp);
        public static final Capability key_f57 = new Capability("key_f57", 246);
        public static final Capability key_f58 = new Capability("key_f58", PacketOpcodes.ClientScriptEventNotify);
        public static final Capability key_f59 = new Capability("key_f59", PacketOpcodes.EnterSceneDoneReq);
        public static final Capability key_f6 = new Capability("key_f6", PacketOpcodes.SeeMonsterRsp);
        public static final Capability key_f60 = new Capability("key_f60", 250);
        public static final Capability key_f61 = new Capability("key_f61", PacketOpcodes.SceneForceLockNotify);
        public static final Capability key_f62 = new Capability("key_f62", 252);
        public static final Capability key_f63 = new Capability("key_f63", PacketOpcodes.ClientTransmitRsp);
        public static final Capability key_f7 = new Capability("key_f7", PacketOpcodes.ExecuteGroupTriggerRsp);
        public static final Capability key_f8 = new Capability("key_f8", 255);
        public static final Capability key_f9 = new Capability("key_f9", 256);
        public static final Capability key_find = new Capability("key_find", PacketOpcodes.CutSceneFinishNotify);
        public static final Capability key_help = new Capability("key_help", PacketOpcodes.SceneAreaUnlockNotify);
        public static final Capability key_home = new Capability("key_home", PacketOpcodes.SeeMonsterReq);
        public static final Capability key_ic = new Capability("key_ic", PacketOpcodes.PersonalSceneJumpReq);
        public static final Capability key_il = new Capability("key_il", PacketOpcodes.SealBattleBeginNotify);
        public static final Capability key_left = new Capability("key_left", PacketOpcodes.SceneEntityMoveRsp);
        public static final Capability key_ll = new Capability("key_ll", PacketOpcodes.MarkEntityInMinMapNotify);
        public static final Capability key_mark = new Capability("key_mark", PacketOpcodes.ScenePlayerInfoNotify);
        public static final Capability key_message = new Capability("key_message", PacketOpcodes.SealBattleEndNotify);
        public static final Capability key_move = new Capability("key_move", PacketOpcodes.SetSceneWeatherAreaRsp);
        public static final Capability key_next = new Capability("key_next", PacketOpcodes.LevelupCityRsp);
        public static final Capability key_npage = new Capability("key_npage", PacketOpcodes.EnterSceneReadyReq);
        public static final Capability key_open = new Capability("key_open", PacketOpcodes.EnterTransPointRegionNotify);
        public static final Capability key_options = new Capability("key_options", PacketOpcodes.SceneEntityMoveReq);
        public static final Capability key_ppage = new Capability("key_ppage", PacketOpcodes.JoinPlayerFailNotify);
        public static final Capability key_previous = new Capability("key_previous", PacketOpcodes.HitClientTrivialNotify);
        public static final Capability key_print = new Capability("key_print", PacketOpcodes.SceneCreateEntityRsp);
        public static final Capability key_redo = new Capability("key_redo", PacketOpcodes.SceneEntityAppearNotify);
        public static final Capability key_reference = new Capability("key_reference", PacketOpcodes.SceneEntityDrownRsp);
        public static final Capability key_refresh = new Capability("key_refresh", PacketOpcodes.BackMyWorldRsp);
        public static final Capability key_replace = new Capability("key_replace", PacketOpcodes.ClientPauseNotify);
        public static final Capability key_restart = new Capability("key_restart", 278);
        public static final Capability key_resume = new Capability("key_resume", 279);
        public static final Capability key_right = new Capability("key_right", PacketOpcodes.SceneEntityDisappearNotify);
        public static final Capability key_save = new Capability("key_save", 281);
        public static final Capability key_sbeg = new Capability("key_sbeg", PacketOpcodes.SceneKickPlayerNotify);
        public static final Capability key_scancel = new Capability("key_scancel", PacketOpcodes.WorldPlayerLocationNotify);
        public static final Capability key_scommand = new Capability("key_scommand", PacketOpcodes.PlatformStopRouteNotify);
        public static final Capability key_scopy = new Capability("key_scopy", PacketOpcodes.SceneForceUnlockNotify);
        public static final Capability key_screate = new Capability("key_screate", PacketOpcodes.EnterScenePeerNotify);
        public static final Capability key_sdc = new Capability("key_sdc", 287);
        public static final Capability key_sdl = new Capability("key_sdl", PacketOpcodes.GetSceneAreaReq);
        public static final Capability key_select = new Capability("key_select", PacketOpcodes.JoinPlayerSceneRsp);
        public static final Capability key_send = new Capability("key_send", PacketOpcodes.ExecuteGroupTriggerReq);
        public static final Capability key_seol = new Capability("key_seol", PacketOpcodes.ScenePlayerSoundNotify);
        public static final Capability key_sexit = new Capability("key_sexit", PacketOpcodes.EntityJumpNotify);
        public static final Capability key_sf = new Capability("key_sf", PacketOpcodes.SceneEntitiesMovesRsp);
        public static final Capability key_sfind = new Capability("key_sfind", 294);
        public static final Capability key_shelp = new Capability("key_shelp", PacketOpcodes.LevelupCityReq);
        public static final Capability key_shome = new Capability("key_shome", PacketOpcodes.AddSeenMonsterNotify);
        public static final Capability key_sic = new Capability("key_sic", PacketOpcodes.EnterSceneDoneRsp);
        public static final Capability key_sleft = new Capability("key_sleft", PacketOpcodes.SceneInitFinishReq);
        public static final Capability key_smessage = new Capability("key_smessage", PacketOpcodes.CutSceneEndNotify);
        public static final Capability key_smove = new Capability("key_smove", 300);
        public static final Capability key_snext = new Capability("key_snext", 301);
        public static final Capability key_soptions = new Capability("key_soptions", 302);
        public static final Capability key_sprevious = new Capability("key_sprevious", 303);
        public static final Capability key_sprint = new Capability("key_sprint", 304);
        public static final Capability key_sr = new Capability("key_sr", 305);
        public static final Capability key_sredo = new Capability("key_sredo", TokenId.CHAR);
        public static final Capability key_sreplace = new Capability("key_sreplace", 307);
        public static final Capability key_sright = new Capability("key_sright", 308);
        public static final Capability key_srsume = new Capability("key_srsume", 309);
        public static final Capability key_ssave = new Capability("key_ssave", TokenId.DEFAULT);
        public static final Capability key_ssuspend = new Capability("key_ssuspend", 311);
        public static final Capability key_stab = new Capability("key_stab", TokenId.DOUBLE);
        public static final Capability key_sundo = new Capability("key_sundo", 313);
        public static final Capability key_suspend = new Capability("key_suspend", 314);
        public static final Capability key_undo = new Capability("key_undo", 315);
        public static final Capability key_up = new Capability("key_up", 316);
        public static final Capability keypad_local = new Capability("keypad_local", 317);
        public static final Capability keypad_xmit = new Capability("keypad_xmit", 318);
        public static final Capability lab_f0 = new Capability("lab_f0", TokenId.GOTO);
        public static final Capability lab_f1 = new Capability("lab_f1", 320);
        public static final Capability lab_f10 = new Capability("lab_f10", 321);
        public static final Capability lab_f2 = new Capability("lab_f2", 322);
        public static final Capability lab_f3 = new Capability("lab_f3", 323);
        public static final Capability lab_f4 = new Capability("lab_f4", 324);
        public static final Capability lab_f5 = new Capability("lab_f5", 325);
        public static final Capability lab_f6 = new Capability("lab_f6", TokenId.LONG);
        public static final Capability lab_f7 = new Capability("lab_f7", 327);
        public static final Capability lab_f8 = new Capability("lab_f8", 328);
        public static final Capability lab_f9 = new Capability("lab_f9", 329);
        public static final Capability label_format = new Capability("label_format", 330);
        public static final Capability label_off = new Capability("label_off", TokenId.PROTECTED);
        public static final Capability label_on = new Capability("label_on", TokenId.PUBLIC);
        public static final Capability meta_off = new Capability("meta_off", TokenId.RETURN);
        public static final Capability meta_on = new Capability("meta_on", TokenId.SHORT);
        public static final Capability micro_column_address = new Capability("micro_column_address", 335);
        public static final Capability micro_down = new Capability("micro_down", 336);
        public static final Capability micro_left = new Capability("micro_left", 337);
        public static final Capability micro_right = new Capability("micro_right", TokenId.SYNCHRONIZED);
        public static final Capability micro_row_address = new Capability("micro_row_address", TokenId.THIS);
        public static final Capability micro_up = new Capability("micro_up", TokenId.THROW);
        public static final Capability newline = new Capability("newline", 341);
        public static final Capability order_of_pins = new Capability("order_of_pins", 342);
        public static final Capability orig_colors = new Capability("orig_colors", 343);
        public static final Capability orig_pair = new Capability("orig_pair", TokenId.VOID);
        public static final Capability pad_char = new Capability("pad_char", 345);
        public static final Capability parm_dch = new Capability("parm_dch", 346);
        public static final Capability parm_delete_line = new Capability("parm_delete_line", 347);
        public static final Capability parm_down_cursor = new Capability("parm_down_cursor", 348);
        public static final Capability parm_down_micro = new Capability("parm_down_micro", 349);
        public static final Capability parm_ich = new Capability("parm_ich", 350);
        public static final Capability parm_index = new Capability("parm_index", 351);
        public static final Capability parm_insert_line = new Capability("parm_insert_line", TokenId.AND_E);
        public static final Capability parm_left_cursor = new Capability("parm_left_cursor", 353);
        public static final Capability parm_left_micro = new Capability("parm_left_micro", 354);
        public static final Capability parm_right_cursor = new Capability("parm_right_cursor", 355);
        public static final Capability parm_right_micro = new Capability("parm_right_micro", 356);
        public static final Capability parm_rindex = new Capability("parm_rindex", TokenId.f3042LE);
        public static final Capability parm_up_cursor = new Capability("parm_up_cursor", 358);
        public static final Capability parm_up_micro = new Capability("parm_up_micro", TokenId.f3044GE);
        public static final Capability pkey_key = new Capability("pkey_key", 360);
        public static final Capability pkey_local = new Capability("pkey_local", TokenId.OR_E);
        public static final Capability pkey_xmit = new Capability("pkey_xmit", 362);
        public static final Capability plab_norm = new Capability("plab_norm", 363);
        public static final Capability print_screen = new Capability("print_screen", 364);
        public static final Capability prtr_non = new Capability("prtr_non", TokenId.LSHIFT_E);
        public static final Capability prtr_off = new Capability("prtr_off", TokenId.RSHIFT);
        public static final Capability prtr_on = new Capability("prtr_on", 367);
        public static final Capability pulse = new Capability("pulse", TokenId.OROR);
        public static final Capability quick_dial = new Capability("quick_dial", TokenId.ANDAND);
        public static final Capability remove_clock = new Capability("remove_clock", 370);
        public static final Capability repeat_char = new Capability("repeat_char", TokenId.ARSHIFT_E);
        public static final Capability req_for_input = new Capability("req_for_input", 372);
        public static final Capability reset_1string = new Capability("reset_1string", PacketOpcodes.AvatarBuffDelNotify);
        public static final Capability reset_2string = new Capability("reset_2string", PacketOpcodes.EvtDestroyGadgetNotify);
        public static final Capability reset_3string = new Capability("reset_3string", PacketOpcodes.EntityAuthorityChangeNotify);
        public static final Capability reset_file = new Capability("reset_file", 376);
        public static final Capability restore_cursor = new Capability("restore_cursor", 377);
        public static final Capability row_address = new Capability("row_address", 378);
        public static final Capability save_cursor = new Capability("save_cursor", PacketOpcodes.MassiveEntityStateChangedNotify);
        public static final Capability scroll_forward = new Capability("scroll_forward", PacketOpcodes.EvtFaceToEntityNotify);
        public static final Capability scroll_reverse = new Capability("scroll_reverse", PacketOpcodes.CreateMassiveEntityRsp);
        public static final Capability select_char_set = new Capability("select_char_set", 382);
        public static final Capability set_attributes = new Capability("set_attributes", PacketOpcodes.DestroyMassiveEntityNotify);
        public static final Capability set_background = new Capability("set_background", 384);
        public static final Capability set_bottom_margin = new Capability("set_bottom_margin", 385);
        public static final Capability set_bottom_margin_parm = new Capability("set_bottom_margin_parm", 386);
        public static final Capability set_clock = new Capability("set_clock", PacketOpcodes.HostPlayerNotify);
        public static final Capability set_color_pair = new Capability("set_color_pair", PacketOpcodes.EvtBulletMoveNotify);
        public static final Capability set_foreground = new Capability("set_foreground", 389);
        public static final Capability set_left_margin = new Capability("set_left_margin", PacketOpcodes.MassiveEntityElementOpBatchNotify);
        public static final Capability set_left_margin_parm = new Capability("set_left_margin_parm", PacketOpcodes.EvtBeingHealedNotify);
        public static final Capability set_right_margin = new Capability("set_right_margin", 392);
        public static final Capability set_right_margin_parm = new Capability("set_right_margin_parm", 393);
        public static final Capability set_tab = new Capability("set_tab", PacketOpcodes.CreateMassiveEntityReq);
        public static final Capability set_top_margin = new Capability("set_top_margin", PacketOpcodes.LuaSetOptionNotify);
        public static final Capability set_top_margin_parm = new Capability("set_top_margin_parm", ActivityInfoOuterClass.ActivityInfo.CURSCORE_FIELD_NUMBER);
        public static final Capability set_window = new Capability("set_window", 397);
        public static final Capability start_bit_image = new Capability("start_bit_image", PacketOpcodes.EvtDoSkillSuccNotify);
        public static final Capability start_char_set_def = new Capability("start_char_set_def", 399);
        public static final Capability stop_bit_image = new Capability("stop_bit_image", 400);
        public static final Capability stop_char_set_def = new Capability("stop_char_set_def", 401);
        public static final Capability subscript_characters = new Capability("subscript_characters", 402);
        public static final Capability superscript_characters = new Capability("superscript_characters", 403);
        public static final Capability tab = new Capability("tab", 404);
        public static final Capability these_cause_cr = new Capability("these_cause_cr", 405);
        public static final Capability to_status_line = new Capability("to_status_line", 406);
        public static final Capability tone = new Capability("tone", 407);
        public static final Capability underline_char = new Capability("underline_char", 408);
        public static final Capability up_half_line = new Capability("up_half_line", 409);
        public static final Capability user0 = new Capability("user0", 410);
        public static final Capability user1 = new Capability("user1", 411);
        public static final Capability user2 = new Capability("user2", 412);
        public static final Capability user3 = new Capability("user3", 413);
        public static final Capability user4 = new Capability("user4", 414);
        public static final Capability user5 = new Capability("user5", 415);
        public static final Capability user6 = new Capability("user6", 416);
        public static final Capability user7 = new Capability("user7", 417);
        public static final Capability user8 = new Capability("user8", 418);
        public static final Capability user9 = new Capability("user9", 419);
        public static final Capability wait_tone = new Capability("wait_tone", 420);
        public static final Capability xoff_character = new Capability("xoff_character", 421);
        public static final Capability xon_character = new Capability("xon_character", 422);
        public static final Capability zero_motion = new Capability("zero_motion", 423);
        public static final Capability alt_scancode_esc = new Capability("alt_scancode_esc", 424);
        public static final Capability bit_image_carriage_return = new Capability("bit_image_carriage_return", PacketOpcodes.BargainStartNotify);
        public static final Capability bit_image_newline = new Capability("bit_image_newline", 426);
        public static final Capability bit_image_repeat = new Capability("bit_image_repeat", PacketOpcodes.GetParentQuestVideoKeyRsp);
        public static final Capability char_set_names = new Capability("char_set_names", 428);
        public static final Capability code_set_init = new Capability("code_set_init", 429);
        public static final Capability color_names = new Capability("color_names", PacketOpcodes.PersonalLineAllDataReq);
        public static final Capability define_bit_image_region = new Capability("define_bit_image_region", HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE_431);
        public static final Capability device_type = new Capability("device_type", 432);
        public static final Capability display_pc_char = new Capability("display_pc_char", 433);
        public static final Capability end_bit_image_region = new Capability("end_bit_image_region", 434);
        public static final Capability enter_pc_charset_mode = new Capability("enter_pc_charset_mode", PacketOpcodes.RedeemLegendaryKeyReq);
        public static final Capability enter_scancode_mode = new Capability("enter_scancode_mode", PacketOpcodes.QuestUpdateQuestTimeVarNotify);
        public static final Capability exit_pc_charset_mode = new Capability("exit_pc_charset_mode", 437);
        public static final Capability exit_scancode_mode = new Capability("exit_scancode_mode", 438);
        public static final Capability get_mouse = new Capability("get_mouse", PacketOpcodes.QuestUpdateQuestVarReq);
        public static final Capability key_mouse = new Capability("key_mouse", 440);
        public static final Capability mouse_info = new Capability("mouse_info", 441);
        public static final Capability pc_term_options = new Capability("pc_term_options", 442);
        public static final Capability pkey_plab = new Capability("pkey_plab", PacketOpcodes.PersonalLineAllDataRsp);
        public static final Capability req_mouse_pos = new Capability("req_mouse_pos", 444);
        public static final Capability scancode_escape = new Capability("scancode_escape", PacketOpcodes.GetAllActivatedBargainDataRsp);
        public static final Capability set0_des_seq = new Capability("set0_des_seq", PacketOpcodes.QuestUpdateQuestVarRsp);
        public static final Capability set1_des_seq = new Capability("set1_des_seq", 447);
        public static final Capability set2_des_seq = new Capability("set2_des_seq", 448);
        public static final Capability set3_des_seq = new Capability("set3_des_seq", 449);
        public static final Capability set_a_background = new Capability("set_a_background", PacketOpcodes.QuestTransmitRsp);
        public static final Capability set_a_foreground = new Capability("set_a_foreground", 451);
        public static final Capability set_color_band = new Capability("set_color_band", PacketOpcodes.UnlockPersonalLineReq);
        public static final Capability set_lr_margin = new Capability("set_lr_margin", PacketOpcodes.CancelFinishParentQuestNotify);
        public static final Capability set_page_length = new Capability("set_page_length", PacketOpcodes.SubmitInferenceWordReq);
        public static final Capability set_tb_margin = new Capability("set_tb_margin", PacketOpcodes.QuestListUpdateNotify);
        public static final Capability enter_horizontal_hl_mode = new Capability("enter_horizontal_hl_mode", PacketOpcodes.AssociateInferenceWordReq);
        public static final Capability enter_left_hl_mode = new Capability("enter_left_hl_mode", 457);
        public static final Capability enter_low_hl_mode = new Capability("enter_low_hl_mode", 458);
        public static final Capability enter_right_hl_mode = new Capability("enter_right_hl_mode", 459);
        public static final Capability enter_top_hl_mode = new Capability("enter_top_hl_mode", 460);
        public static final Capability enter_vertical_hl_mode = new Capability("enter_vertical_hl_mode", 461);
        public static final Capability set_a_attributes = new Capability("set_a_attributes", PacketOpcodes.GetQuestTalkHistoryRsp);
        public static final Capability set_pglen_inch = new Capability("set_pglen_inch", PacketOpcodes.ParentQuestInferenceDataNotify);
        private static final /* synthetic */ Capability[] $VALUES;

        public static Capability[] values() {
            return (Capability[]) $VALUES.clone();
        }

        public static Capability valueOf(String name) {
            return (Capability) Enum.valueOf(Capability.class, name);
        }

        private Capability(String str, int i) {
        }

        static {
            Capability[] capabilityArr = new Capability[PacketOpcodes.GetQuestLackingResourceReq];
            capabilityArr[0] = auto_left_margin;
            capabilityArr[1] = auto_right_margin;
            capabilityArr[2] = back_color_erase;
            capabilityArr[3] = can_change;
            capabilityArr[4] = ceol_standout_glitch;
            capabilityArr[5] = col_addr_glitch;
            capabilityArr[6] = cpi_changes_res;
            capabilityArr[7] = cr_cancels_micro_mode;
            capabilityArr[8] = dest_tabs_magic_smso;
            capabilityArr[9] = eat_newline_glitch;
            capabilityArr[10] = erase_overstrike;
            capabilityArr[11] = generic_type;
            capabilityArr[12] = hard_copy;
            capabilityArr[13] = hard_cursor;
            capabilityArr[14] = has_meta_key;
            capabilityArr[15] = has_print_wheel;
            capabilityArr[16] = has_status_line;
            capabilityArr[17] = hue_lightness_saturation;
            capabilityArr[18] = insert_null_glitch;
            capabilityArr[19] = lpi_changes_res;
            capabilityArr[20] = memory_above;
            capabilityArr[21] = memory_below;
            capabilityArr[22] = move_insert_mode;
            capabilityArr[23] = move_standout_mode;
            capabilityArr[24] = needs_xon_xoff;
            capabilityArr[25] = no_esc_ctlc;
            capabilityArr[26] = no_pad_char;
            capabilityArr[27] = non_dest_scroll_region;
            capabilityArr[28] = non_rev_rmcup;
            capabilityArr[29] = over_strike;
            capabilityArr[30] = prtr_silent;
            capabilityArr[31] = row_addr_glitch;
            capabilityArr[32] = semi_auto_right_margin;
            capabilityArr[33] = status_line_esc_ok;
            capabilityArr[34] = tilde_glitch;
            capabilityArr[35] = transparent_underline;
            capabilityArr[36] = xon_xoff;
            capabilityArr[37] = columns;
            capabilityArr[38] = init_tabs;
            capabilityArr[39] = label_height;
            capabilityArr[40] = label_width;
            capabilityArr[41] = lines;
            capabilityArr[42] = lines_of_memory;
            capabilityArr[43] = magic_cookie_glitch;
            capabilityArr[44] = max_attributes;
            capabilityArr[45] = max_colors;
            capabilityArr[46] = max_pairs;
            capabilityArr[47] = maximum_windows;
            capabilityArr[48] = no_color_video;
            capabilityArr[49] = num_labels;
            capabilityArr[50] = padding_baud_rate;
            capabilityArr[51] = virtual_terminal;
            capabilityArr[52] = width_status_line;
            capabilityArr[53] = bit_image_entwining;
            capabilityArr[54] = bit_image_type;
            capabilityArr[55] = buffer_capacity;
            capabilityArr[56] = buttons;
            capabilityArr[57] = dot_horz_spacing;
            capabilityArr[58] = dot_vert_spacing;
            capabilityArr[59] = max_micro_address;
            capabilityArr[60] = max_micro_jump;
            capabilityArr[61] = micro_col_size;
            capabilityArr[62] = micro_line_size;
            capabilityArr[63] = number_of_pins;
            capabilityArr[64] = output_res_char;
            capabilityArr[65] = output_res_horz_inch;
            capabilityArr[66] = output_res_line;
            capabilityArr[67] = output_res_vert_inch;
            capabilityArr[68] = print_rate;
            capabilityArr[69] = wide_char_size;
            capabilityArr[70] = acs_chars;
            capabilityArr[71] = back_tab;
            capabilityArr[72] = bell;
            capabilityArr[73] = carriage_return;
            capabilityArr[74] = change_char_pitch;
            capabilityArr[75] = change_line_pitch;
            capabilityArr[76] = change_res_horz;
            capabilityArr[77] = change_res_vert;
            capabilityArr[78] = change_scroll_region;
            capabilityArr[79] = char_padding;
            capabilityArr[80] = clear_all_tabs;
            capabilityArr[81] = clear_margins;
            capabilityArr[82] = clear_screen;
            capabilityArr[83] = clr_bol;
            capabilityArr[84] = clr_eol;
            capabilityArr[85] = clr_eos;
            capabilityArr[86] = column_address;
            capabilityArr[87] = command_character;
            capabilityArr[88] = create_window;
            capabilityArr[89] = cursor_address;
            capabilityArr[90] = cursor_down;
            capabilityArr[91] = cursor_home;
            capabilityArr[92] = cursor_invisible;
            capabilityArr[93] = cursor_left;
            capabilityArr[94] = cursor_mem_address;
            capabilityArr[95] = cursor_normal;
            capabilityArr[96] = cursor_right;
            capabilityArr[97] = cursor_to_ll;
            capabilityArr[98] = cursor_up;
            capabilityArr[99] = cursor_visible;
            capabilityArr[100] = define_char;
            capabilityArr[101] = delete_character;
            capabilityArr[102] = delete_line;
            capabilityArr[103] = dial_phone;
            capabilityArr[104] = dis_status_line;
            capabilityArr[105] = display_clock;
            capabilityArr[106] = down_half_line;
            capabilityArr[107] = ena_acs;
            capabilityArr[108] = enter_alt_charset_mode;
            capabilityArr[109] = enter_am_mode;
            capabilityArr[110] = enter_blink_mode;
            capabilityArr[111] = enter_bold_mode;
            capabilityArr[112] = enter_ca_mode;
            capabilityArr[113] = enter_delete_mode;
            capabilityArr[114] = enter_dim_mode;
            capabilityArr[115] = enter_doublewide_mode;
            capabilityArr[116] = enter_draft_quality;
            capabilityArr[117] = enter_insert_mode;
            capabilityArr[118] = enter_italics_mode;
            capabilityArr[119] = enter_leftward_mode;
            capabilityArr[120] = enter_micro_mode;
            capabilityArr[121] = enter_near_letter_quality;
            capabilityArr[122] = enter_normal_quality;
            capabilityArr[123] = enter_protected_mode;
            capabilityArr[124] = enter_reverse_mode;
            capabilityArr[125] = enter_secure_mode;
            capabilityArr[126] = enter_shadow_mode;
            capabilityArr[127] = enter_standout_mode;
            capabilityArr[128] = enter_subscript_mode;
            capabilityArr[129] = enter_superscript_mode;
            capabilityArr[130] = enter_underline_mode;
            capabilityArr[131] = enter_upward_mode;
            capabilityArr[132] = enter_xon_mode;
            capabilityArr[133] = erase_chars;
            capabilityArr[134] = exit_alt_charset_mode;
            capabilityArr[135] = exit_am_mode;
            capabilityArr[136] = exit_attribute_mode;
            capabilityArr[137] = exit_ca_mode;
            capabilityArr[138] = exit_delete_mode;
            capabilityArr[139] = exit_doublewide_mode;
            capabilityArr[140] = exit_insert_mode;
            capabilityArr[141] = exit_italics_mode;
            capabilityArr[142] = exit_leftward_mode;
            capabilityArr[143] = exit_micro_mode;
            capabilityArr[144] = exit_shadow_mode;
            capabilityArr[145] = exit_standout_mode;
            capabilityArr[146] = exit_subscript_mode;
            capabilityArr[147] = exit_superscript_mode;
            capabilityArr[148] = exit_underline_mode;
            capabilityArr[149] = exit_upward_mode;
            capabilityArr[150] = exit_xon_mode;
            capabilityArr[151] = fixed_pause;
            capabilityArr[152] = flash_hook;
            capabilityArr[153] = flash_screen;
            capabilityArr[154] = form_feed;
            capabilityArr[155] = from_status_line;
            capabilityArr[156] = goto_window;
            capabilityArr[157] = hangup;
            capabilityArr[158] = init_1string;
            capabilityArr[159] = init_2string;
            capabilityArr[160] = init_3string;
            capabilityArr[161] = init_file;
            capabilityArr[162] = init_prog;
            capabilityArr[163] = initialize_color;
            capabilityArr[164] = initialize_pair;
            capabilityArr[165] = insert_character;
            capabilityArr[166] = insert_line;
            capabilityArr[167] = insert_padding;
            capabilityArr[168] = key_a1;
            capabilityArr[169] = key_a3;
            capabilityArr[170] = key_b2;
            capabilityArr[171] = key_backspace;
            capabilityArr[172] = key_beg;
            capabilityArr[173] = key_btab;
            capabilityArr[174] = key_c1;
            capabilityArr[175] = key_c3;
            capabilityArr[176] = key_cancel;
            capabilityArr[177] = key_catab;
            capabilityArr[178] = key_clear;
            capabilityArr[179] = key_close;
            capabilityArr[180] = key_command;
            capabilityArr[181] = key_copy;
            capabilityArr[182] = key_create;
            capabilityArr[183] = key_ctab;
            capabilityArr[184] = key_dc;
            capabilityArr[185] = key_dl;
            capabilityArr[186] = key_down;
            capabilityArr[187] = key_eic;
            capabilityArr[188] = key_end;
            capabilityArr[189] = key_enter;
            capabilityArr[190] = key_eol;
            capabilityArr[191] = key_eos;
            capabilityArr[192] = key_exit;
            capabilityArr[193] = key_f0;
            capabilityArr[194] = key_f1;
            capabilityArr[195] = key_f10;
            capabilityArr[196] = key_f11;
            capabilityArr[197] = key_f12;
            capabilityArr[198] = key_f13;
            capabilityArr[199] = key_f14;
            capabilityArr[200] = key_f15;
            capabilityArr[201] = key_f16;
            capabilityArr[202] = key_f17;
            capabilityArr[203] = key_f18;
            capabilityArr[204] = key_f19;
            capabilityArr[205] = key_f2;
            capabilityArr[206] = key_f20;
            capabilityArr[207] = key_f21;
            capabilityArr[208] = key_f22;
            capabilityArr[209] = key_f23;
            capabilityArr[210] = key_f24;
            capabilityArr[211] = key_f25;
            capabilityArr[212] = key_f26;
            capabilityArr[213] = key_f27;
            capabilityArr[214] = key_f28;
            capabilityArr[215] = key_f29;
            capabilityArr[216] = key_f3;
            capabilityArr[217] = key_f30;
            capabilityArr[218] = key_f31;
            capabilityArr[219] = key_f32;
            capabilityArr[220] = key_f33;
            capabilityArr[221] = key_f34;
            capabilityArr[222] = key_f35;
            capabilityArr[223] = key_f36;
            capabilityArr[224] = key_f37;
            capabilityArr[225] = key_f38;
            capabilityArr[226] = key_f39;
            capabilityArr[227] = key_f4;
            capabilityArr[228] = key_f40;
            capabilityArr[229] = key_f41;
            capabilityArr[230] = key_f42;
            capabilityArr[231] = key_f43;
            capabilityArr[232] = key_f44;
            capabilityArr[233] = key_f45;
            capabilityArr[234] = key_f46;
            capabilityArr[235] = key_f47;
            capabilityArr[236] = key_f48;
            capabilityArr[237] = key_f49;
            capabilityArr[238] = key_f5;
            capabilityArr[239] = key_f50;
            capabilityArr[240] = key_f51;
            capabilityArr[241] = key_f52;
            capabilityArr[242] = key_f53;
            capabilityArr[243] = key_f54;
            capabilityArr[244] = key_f55;
            capabilityArr[245] = key_f56;
            capabilityArr[246] = key_f57;
            capabilityArr[247] = key_f58;
            capabilityArr[248] = key_f59;
            capabilityArr[249] = key_f6;
            capabilityArr[250] = key_f60;
            capabilityArr[251] = key_f61;
            capabilityArr[252] = key_f62;
            capabilityArr[253] = key_f63;
            capabilityArr[254] = key_f7;
            capabilityArr[255] = key_f8;
            capabilityArr[256] = key_f9;
            capabilityArr[257] = key_find;
            capabilityArr[258] = key_help;
            capabilityArr[259] = key_home;
            capabilityArr[260] = key_ic;
            capabilityArr[261] = key_il;
            capabilityArr[262] = key_left;
            capabilityArr[263] = key_ll;
            capabilityArr[264] = key_mark;
            capabilityArr[265] = key_message;
            capabilityArr[266] = key_move;
            capabilityArr[267] = key_next;
            capabilityArr[268] = key_npage;
            capabilityArr[269] = key_open;
            capabilityArr[270] = key_options;
            capabilityArr[271] = key_ppage;
            capabilityArr[272] = key_previous;
            capabilityArr[273] = key_print;
            capabilityArr[274] = key_redo;
            capabilityArr[275] = key_reference;
            capabilityArr[276] = key_refresh;
            capabilityArr[277] = key_replace;
            capabilityArr[278] = key_restart;
            capabilityArr[279] = key_resume;
            capabilityArr[280] = key_right;
            capabilityArr[281] = key_save;
            capabilityArr[282] = key_sbeg;
            capabilityArr[283] = key_scancel;
            capabilityArr[284] = key_scommand;
            capabilityArr[285] = key_scopy;
            capabilityArr[286] = key_screate;
            capabilityArr[287] = key_sdc;
            capabilityArr[288] = key_sdl;
            capabilityArr[289] = key_select;
            capabilityArr[290] = key_send;
            capabilityArr[291] = key_seol;
            capabilityArr[292] = key_sexit;
            capabilityArr[293] = key_sf;
            capabilityArr[294] = key_sfind;
            capabilityArr[295] = key_shelp;
            capabilityArr[296] = key_shome;
            capabilityArr[297] = key_sic;
            capabilityArr[298] = key_sleft;
            capabilityArr[299] = key_smessage;
            capabilityArr[300] = key_smove;
            capabilityArr[301] = key_snext;
            capabilityArr[302] = key_soptions;
            capabilityArr[303] = key_sprevious;
            capabilityArr[304] = key_sprint;
            capabilityArr[305] = key_sr;
            capabilityArr[306] = key_sredo;
            capabilityArr[307] = key_sreplace;
            capabilityArr[308] = key_sright;
            capabilityArr[309] = key_srsume;
            capabilityArr[310] = key_ssave;
            capabilityArr[311] = key_ssuspend;
            capabilityArr[312] = key_stab;
            capabilityArr[313] = key_sundo;
            capabilityArr[314] = key_suspend;
            capabilityArr[315] = key_undo;
            capabilityArr[316] = key_up;
            capabilityArr[317] = keypad_local;
            capabilityArr[318] = keypad_xmit;
            capabilityArr[319] = lab_f0;
            capabilityArr[320] = lab_f1;
            capabilityArr[321] = lab_f10;
            capabilityArr[322] = lab_f2;
            capabilityArr[323] = lab_f3;
            capabilityArr[324] = lab_f4;
            capabilityArr[325] = lab_f5;
            capabilityArr[326] = lab_f6;
            capabilityArr[327] = lab_f7;
            capabilityArr[328] = lab_f8;
            capabilityArr[329] = lab_f9;
            capabilityArr[330] = label_format;
            capabilityArr[331] = label_off;
            capabilityArr[332] = label_on;
            capabilityArr[333] = meta_off;
            capabilityArr[334] = meta_on;
            capabilityArr[335] = micro_column_address;
            capabilityArr[336] = micro_down;
            capabilityArr[337] = micro_left;
            capabilityArr[338] = micro_right;
            capabilityArr[339] = micro_row_address;
            capabilityArr[340] = micro_up;
            capabilityArr[341] = newline;
            capabilityArr[342] = order_of_pins;
            capabilityArr[343] = orig_colors;
            capabilityArr[344] = orig_pair;
            capabilityArr[345] = pad_char;
            capabilityArr[346] = parm_dch;
            capabilityArr[347] = parm_delete_line;
            capabilityArr[348] = parm_down_cursor;
            capabilityArr[349] = parm_down_micro;
            capabilityArr[350] = parm_ich;
            capabilityArr[351] = parm_index;
            capabilityArr[352] = parm_insert_line;
            capabilityArr[353] = parm_left_cursor;
            capabilityArr[354] = parm_left_micro;
            capabilityArr[355] = parm_right_cursor;
            capabilityArr[356] = parm_right_micro;
            capabilityArr[357] = parm_rindex;
            capabilityArr[358] = parm_up_cursor;
            capabilityArr[359] = parm_up_micro;
            capabilityArr[360] = pkey_key;
            capabilityArr[361] = pkey_local;
            capabilityArr[362] = pkey_xmit;
            capabilityArr[363] = plab_norm;
            capabilityArr[364] = print_screen;
            capabilityArr[365] = prtr_non;
            capabilityArr[366] = prtr_off;
            capabilityArr[367] = prtr_on;
            capabilityArr[368] = pulse;
            capabilityArr[369] = quick_dial;
            capabilityArr[370] = remove_clock;
            capabilityArr[371] = repeat_char;
            capabilityArr[372] = req_for_input;
            capabilityArr[373] = reset_1string;
            capabilityArr[374] = reset_2string;
            capabilityArr[375] = reset_3string;
            capabilityArr[376] = reset_file;
            capabilityArr[377] = restore_cursor;
            capabilityArr[378] = row_address;
            capabilityArr[379] = save_cursor;
            capabilityArr[380] = scroll_forward;
            capabilityArr[381] = scroll_reverse;
            capabilityArr[382] = select_char_set;
            capabilityArr[383] = set_attributes;
            capabilityArr[384] = set_background;
            capabilityArr[385] = set_bottom_margin;
            capabilityArr[386] = set_bottom_margin_parm;
            capabilityArr[387] = set_clock;
            capabilityArr[388] = set_color_pair;
            capabilityArr[389] = set_foreground;
            capabilityArr[390] = set_left_margin;
            capabilityArr[391] = set_left_margin_parm;
            capabilityArr[392] = set_right_margin;
            capabilityArr[393] = set_right_margin_parm;
            capabilityArr[394] = set_tab;
            capabilityArr[395] = set_top_margin;
            capabilityArr[396] = set_top_margin_parm;
            capabilityArr[397] = set_window;
            capabilityArr[398] = start_bit_image;
            capabilityArr[399] = start_char_set_def;
            capabilityArr[400] = stop_bit_image;
            capabilityArr[401] = stop_char_set_def;
            capabilityArr[402] = subscript_characters;
            capabilityArr[403] = superscript_characters;
            capabilityArr[404] = tab;
            capabilityArr[405] = these_cause_cr;
            capabilityArr[406] = to_status_line;
            capabilityArr[407] = tone;
            capabilityArr[408] = underline_char;
            capabilityArr[409] = up_half_line;
            capabilityArr[410] = user0;
            capabilityArr[411] = user1;
            capabilityArr[412] = user2;
            capabilityArr[413] = user3;
            capabilityArr[414] = user4;
            capabilityArr[415] = user5;
            capabilityArr[416] = user6;
            capabilityArr[417] = user7;
            capabilityArr[418] = user8;
            capabilityArr[419] = user9;
            capabilityArr[420] = wait_tone;
            capabilityArr[421] = xoff_character;
            capabilityArr[422] = xon_character;
            capabilityArr[423] = zero_motion;
            capabilityArr[424] = alt_scancode_esc;
            capabilityArr[425] = bit_image_carriage_return;
            capabilityArr[426] = bit_image_newline;
            capabilityArr[427] = bit_image_repeat;
            capabilityArr[428] = char_set_names;
            capabilityArr[429] = code_set_init;
            capabilityArr[430] = color_names;
            capabilityArr[431] = define_bit_image_region;
            capabilityArr[432] = device_type;
            capabilityArr[433] = display_pc_char;
            capabilityArr[434] = end_bit_image_region;
            capabilityArr[435] = enter_pc_charset_mode;
            capabilityArr[436] = enter_scancode_mode;
            capabilityArr[437] = exit_pc_charset_mode;
            capabilityArr[438] = exit_scancode_mode;
            capabilityArr[439] = get_mouse;
            capabilityArr[440] = key_mouse;
            capabilityArr[441] = mouse_info;
            capabilityArr[442] = pc_term_options;
            capabilityArr[443] = pkey_plab;
            capabilityArr[444] = req_mouse_pos;
            capabilityArr[445] = scancode_escape;
            capabilityArr[446] = set0_des_seq;
            capabilityArr[447] = set1_des_seq;
            capabilityArr[448] = set2_des_seq;
            capabilityArr[449] = set3_des_seq;
            capabilityArr[450] = set_a_background;
            capabilityArr[451] = set_a_foreground;
            capabilityArr[452] = set_color_band;
            capabilityArr[453] = set_lr_margin;
            capabilityArr[454] = set_page_length;
            capabilityArr[455] = set_tb_margin;
            capabilityArr[456] = enter_horizontal_hl_mode;
            capabilityArr[457] = enter_left_hl_mode;
            capabilityArr[458] = enter_low_hl_mode;
            capabilityArr[459] = enter_right_hl_mode;
            capabilityArr[460] = enter_top_hl_mode;
            capabilityArr[461] = enter_vertical_hl_mode;
            capabilityArr[462] = set_a_attributes;
            capabilityArr[463] = set_pglen_inch;
            $VALUES = capabilityArr;
        }

        public String[] getNames() {
            return (String[]) InfoCmp.getCapabilitiesByName().entrySet().stream().filter(e -> {
                return e.getValue() == this;
            }).map((v0) -> {
                return v0.getKey();
            }).toArray(x$0 -> {
                return new String[x$0];
            });
        }

        public static Capability byName(String name) {
            return InfoCmp.getCapabilitiesByName().get(name);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:11:0x0060
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.util.Map<java.lang.String, org.jline.utils.InfoCmp.Capability> getCapabilitiesByName() {
        /*
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r1 = r0
            r1.<init>()
            r7 = r0
            java.lang.Class<org.jline.utils.InfoCmp> r0 = org.jline.utils.InfoCmp.class
            java.lang.String r1 = "capabilities.txt"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)     // Catch: IOException -> 0x0086
            r8 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: IOException -> 0x0086, Throwable -> 0x0072
            r1 = r0
            org.jline.utils.InputStreamReader r2 = new org.jline.utils.InputStreamReader     // Catch: IOException -> 0x0086, Throwable -> 0x0072
            r3 = r2
            r4 = r8
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch: IOException -> 0x0086, Throwable -> 0x0072
            r3.<init>(r4, r5)     // Catch: IOException -> 0x0086, Throwable -> 0x0072
            r1.<init>(r2)     // Catch: IOException -> 0x0086, Throwable -> 0x0072
            r9 = r0
            r0 = r9
            java.util.stream.Stream r0 = r0.lines()     // Catch: Throwable -> 0x0060, IOException -> 0x0086, Throwable -> 0x0072
            java.util.Map<java.lang.String, org.jline.utils.InfoCmp$Capability> r1 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.trim();
            }     // Catch: Throwable -> 0x0060, IOException -> 0x0086, Throwable -> 0x0072
            java.util.stream.Stream r0 = r0.map(r1)     // Catch: Throwable -> 0x0060, IOException -> 0x0086, Throwable -> 0x0072
            java.util.Map<java.lang.String, org.jline.utils.InfoCmp$Capability> r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$getCapabilitiesByName$0(v0);
            }     // Catch: Throwable -> 0x0060, IOException -> 0x0086, Throwable -> 0x0072
            java.util.stream.Stream r0 = r0.filter(r1)     // Catch: Throwable -> 0x0060, IOException -> 0x0086, Throwable -> 0x0072
            java.util.Map<java.lang.String, org.jline.utils.InfoCmp$Capability> r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$getCapabilitiesByName$1(v0);
            }     // Catch: Throwable -> 0x0060, IOException -> 0x0086, Throwable -> 0x0072
            java.util.stream.Stream r0 = r0.filter(r1)     // Catch: Throwable -> 0x0060, IOException -> 0x0086, Throwable -> 0x0072
            r1 = r7
            java.util.Map<java.lang.String, org.jline.utils.InfoCmp$Capability> r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                lambda$getCapabilitiesByName$2(r1, v1);
            }     // Catch: Throwable -> 0x0060, IOException -> 0x0086, Throwable -> 0x0072
            r0.forEach(r1)     // Catch: Throwable -> 0x0060, IOException -> 0x0086, Throwable -> 0x0072
            r0 = r7
            r10 = r0
            r0 = r9
            r0.close()     // Catch: IOException -> 0x0086, Throwable -> 0x0072
            r0 = r8
            if (r0 == 0) goto L_0x005e
            r0 = r8
            r0.close()     // Catch: IOException -> 0x0086
        L_0x005e:
            r0 = r10
            return r0
        L_0x0060:
            r10 = move-exception
            r0 = r9
            r0.close()     // Catch: IOException -> 0x0086, Throwable -> 0x0068, Throwable -> 0x0072
            goto L_0x0070
        L_0x0068:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)     // Catch: IOException -> 0x0086, Throwable -> 0x0072
        L_0x0070:
            r0 = r10
            throw r0     // Catch: IOException -> 0x0086, Throwable -> 0x0072
        L_0x0072:
            r9 = move-exception
            r0 = r8
            if (r0 == 0) goto L_0x0084
            r0 = r8
            r0.close()     // Catch: IOException -> 0x0086, Throwable -> 0x007e
            goto L_0x0084
        L_0x007e:
            r10 = move-exception
            r0 = r9
            r1 = r10
            r0.addSuppressed(r1)     // Catch: IOException -> 0x0086
        L_0x0084:
            r0 = r9
            throw r0     // Catch: IOException -> 0x0086
        L_0x0086:
            r8 = move-exception
            java.io.IOError r0 = new java.io.IOError
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.InfoCmp.getCapabilitiesByName():java.util.Map");
    }

    public static void setDefaultInfoCmp(String terminal, String caps) {
        CAPS.putIfAbsent(terminal, caps);
    }

    public static void setDefaultInfoCmp(String terminal, Supplier<String> caps) {
        CAPS.putIfAbsent(terminal, caps);
    }

    public static String getInfoCmp(String terminal) throws IOException, InterruptedException {
        String caps = getLoadedInfoCmp(terminal);
        if (caps == null) {
            caps = ExecHelper.waitAndCapture(new ProcessBuilder(OSUtils.INFOCMP_COMMAND, terminal).start());
            CAPS.put(terminal, caps);
        }
        return caps;
    }

    public static String getLoadedInfoCmp(String terminal) {
        Object caps = CAPS.get(terminal);
        if (caps instanceof Supplier) {
            caps = ((Supplier) caps).get();
        }
        return (String) caps;
    }

    public static void parseInfoCmp(String capabilities, Set<Capability> bools, Map<Capability, Integer> ints, Map<Capability, String> strings) {
        int iVal;
        Map<String, Capability> capsByName = getCapabilitiesByName();
        String[] lines = capabilities.split("\n");
        for (int i = 1; i < lines.length; i++) {
            Matcher m = Pattern.compile("\\s*(([^,]|\\\\,)+)\\s*[,$]").matcher(lines[i]);
            while (m.find()) {
                String cap = m.group(1);
                if (cap.contains(LineReaderImpl.DEFAULT_COMMENT_BEGIN)) {
                    int index = cap.indexOf(35);
                    String key = cap.substring(0, index);
                    String val = cap.substring(index + 1);
                    if ("0".equals(val)) {
                        iVal = 0;
                    } else if (val.startsWith("0x")) {
                        iVal = Integer.parseInt(val.substring(2), 16);
                    } else if (val.startsWith("0")) {
                        iVal = Integer.parseInt(val.substring(1), 8);
                    } else {
                        iVal = Integer.parseInt(val);
                    }
                    Capability c = capsByName.get(key);
                    if (c != null) {
                        ints.put(c, Integer.valueOf(iVal));
                    }
                } else if (cap.contains("=")) {
                    int index2 = cap.indexOf(61);
                    String key2 = cap.substring(0, index2);
                    String val2 = cap.substring(index2 + 1);
                    Capability c2 = capsByName.get(key2);
                    if (c2 != null) {
                        strings.put(c2, val2);
                    }
                } else {
                    Capability c3 = capsByName.get(cap);
                    if (c3 != null) {
                        bools.add(c3);
                    }
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0050
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static java.lang.String loadDefaultInfoCmp(java.lang.String r7) {
        /*
            java.lang.Class<org.jline.utils.InfoCmp> r0 = org.jline.utils.InfoCmp.class
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: IOException -> 0x0076
            r2 = r1
            r2.<init>()     // Catch: IOException -> 0x0076
            r2 = r7
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: IOException -> 0x0076
            java.lang.String r2 = ".caps"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: IOException -> 0x0076
            java.lang.String r1 = r1.toString()     // Catch: IOException -> 0x0076
            java.io.InputStream r0 = r0.getResourceAsStream(r1)     // Catch: IOException -> 0x0076
            r8 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: IOException -> 0x0076, Throwable -> 0x0062
            r1 = r0
            org.jline.utils.InputStreamReader r2 = new org.jline.utils.InputStreamReader     // Catch: IOException -> 0x0076, Throwable -> 0x0062
            r3 = r2
            r4 = r8
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch: IOException -> 0x0076, Throwable -> 0x0062
            r3.<init>(r4, r5)     // Catch: IOException -> 0x0076, Throwable -> 0x0062
            r1.<init>(r2)     // Catch: IOException -> 0x0076, Throwable -> 0x0062
            r9 = r0
            r0 = r9
            java.util.stream.Stream r0 = r0.lines()     // Catch: IOException -> 0x0076, Throwable -> 0x0050, Throwable -> 0x0062
            java.lang.String r1 = "\n"
            java.lang.String r2 = ""
            java.lang.String r3 = "\n"
            java.util.stream.Collector r1 = java.util.stream.Collectors.joining(r1, r2, r3)     // Catch: IOException -> 0x0076, Throwable -> 0x0050, Throwable -> 0x0062
            java.lang.Object r0 = r0.collect(r1)     // Catch: IOException -> 0x0076, Throwable -> 0x0050, Throwable -> 0x0062
            java.lang.String r0 = (java.lang.String) r0     // Catch: IOException -> 0x0076, Throwable -> 0x0050, Throwable -> 0x0062
            r10 = r0
            r0 = r9
            r0.close()     // Catch: IOException -> 0x0076, Throwable -> 0x0062
            r0 = r8
            if (r0 == 0) goto L_0x004e
            r0 = r8
            r0.close()     // Catch: IOException -> 0x0076
        L_0x004e:
            r0 = r10
            return r0
        L_0x0050:
            r10 = move-exception
            r0 = r9
            r0.close()     // Catch: IOException -> 0x0076, Throwable -> 0x0058, Throwable -> 0x0062
            goto L_0x0060
        L_0x0058:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)     // Catch: IOException -> 0x0076, Throwable -> 0x0062
        L_0x0060:
            r0 = r10
            throw r0     // Catch: IOException -> 0x0076, Throwable -> 0x0062
        L_0x0062:
            r9 = move-exception
            r0 = r8
            if (r0 == 0) goto L_0x0074
            r0 = r8
            r0.close()     // Catch: IOException -> 0x0076, Throwable -> 0x006e
            goto L_0x0074
        L_0x006e:
            r10 = move-exception
            r0 = r9
            r1 = r10
            r0.addSuppressed(r1)     // Catch: IOException -> 0x0076
        L_0x0074:
            r0 = r9
            throw r0     // Catch: IOException -> 0x0076
        L_0x0076:
            r8 = move-exception
            java.io.IOError r0 = new java.io.IOError
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.InfoCmp.loadDefaultInfoCmp(java.lang.String):java.lang.String");
    }
}
