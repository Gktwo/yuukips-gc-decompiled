package org.jline.style;

import emu.grasscutter.net.packet.PacketOpcodes;

@Deprecated
/* loaded from: grasscutter.jar:org/jline/style/StyleColor.class */
public enum StyleColor {
    black(0),
    maroon(1),
    green(2),
    olive(3),
    navy(4),
    purple(5),
    teal(6),
    silver(7),
    grey(8),
    red(9),
    lime(10),
    yellow(11),
    blue(12),
    fuchsia(13),
    aqua(14),
    white(15),
    grey0(16),
    navyblue(17),
    darkblue(18),
    blue3(19),
    blue3a(20),
    blue1(21),
    darkgreen(22),
    deepskyblue4(23),
    deepskyblue4a(24),
    deepskyblue4b(25),
    dodgerblue3(26),
    dodgerblue2(27),
    green4(28),
    springgreen4(29),
    turquoise4(30),
    deepskyblue3(31),
    deepskyblue3a(32),
    dodgerblue1(33),
    green3(34),
    springgreen3(35),
    darkcyan(36),
    lightseagreen(37),
    deepskyblue2(38),
    deepskyblue1(39),
    green3a(40),
    springgreen3a(41),
    springgreen2(42),
    cyan3(43),
    darkturquoise(44),
    turquoise2(45),
    green1(46),
    springgreen2a(47),
    springgreen1(48),
    mediumspringgreen(49),
    cyan2(50),
    cyan1(51),
    darkred(52),
    deeppink4(53),
    purple4(54),
    purple4a(55),
    purple3(56),
    blueviolet(57),
    orange4(58),
    grey37(59),
    mediumpurple4(60),
    slateblue3(61),
    slateblue3a(62),
    royalblue1(63),
    chartreuse4(64),
    darkseagreen4(65),
    paleturquoise4(66),
    steelblue(67),
    steelblue3(68),
    cornflowerblue(69),
    chartreuse3(70),
    darkseagreen4a(71),
    cadetblue(72),
    cadetbluea(73),
    skyblue3(74),
    steelblue1(75),
    chartreuse3a(76),
    palegreen3(77),
    seagreen3(78),
    aquamarine3(79),
    mediumturquoise(80),
    steelblue1a(81),
    chartreuse2(82),
    seagreen2(83),
    seagreen1(84),
    seagreen1a(85),
    aquamarine1(86),
    darkslategray2(87),
    darkreda(88),
    deeppink4a(89),
    darkmagenta(90),
    darkmagentaa(91),
    darkviolet(92),
    purplea(93),
    orange4a(94),
    lightpink4(95),
    plum4(96),
    mediumpurple3(97),
    mediumpurple3a(98),
    slateblue1(99),
    yellow4(100),
    wheat4(101),
    grey53(102),
    lightslategrey(103),
    mediumpurple(104),
    lightslateblue(105),
    yellow4a(106),
    darkolivegreen3(107),
    darkseagreen(108),
    lightskyblue3(109),
    lightskyblue3a(110),
    skyblue2(111),
    chartreuse2a(112),
    darkolivegreen3a(113),
    palegreen3a(114),
    darkseagreen3(115),
    darkslategray3(116),
    skyblue1(117),
    chartreuse1(118),
    lightgreen(119),
    lightgreena(120),
    palegreen1(121),
    aquamarine1a(122),
    darkslategray1(123),
    red3(124),
    deeppink4b(125),
    mediumvioletred(126),
    magenta3(127),
    darkvioleta(128),
    purpleb(129),
    darkorange3(130),
    indianred(131),
    hotpink3(132),
    mediumorchid3(133),
    mediumorchid(134),
    mediumpurple2(135),
    darkgoldenrod(136),
    lightsalmon3(137),
    rosybrown(138),
    grey63(139),
    mediumpurple2a(140),
    mediumpurple1(141),
    gold3(142),
    darkkhaki(143),
    navajowhite3(144),
    grey69(145),
    lightsteelblue3(146),
    lightsteelblue(147),
    yellow3(148),
    darkolivegreen3b(149),
    darkseagreen3a(150),
    darkseagreen2(151),
    lightcyan3(152),
    lightskyblue1(153),
    greenyellow(154),
    darkolivegreen2(155),
    palegreen1a(156),
    darkseagreen2a(157),
    darkseagreen1(158),
    paleturquoise1(159),
    red3a(160),
    deeppink3(161),
    deeppink3a(162),
    magenta3a(163),
    magenta3b(164),
    magenta2(165),
    darkorange3a(166),
    indianreda(167),
    hotpink3a(168),
    hotpink2(169),
    orchid(170),
    mediumorchid1(171),
    orange3(172),
    lightsalmon3a(173),
    lightpink3(174),
    pink3(175),
    plum3(176),
    violet(177),
    gold3a(178),
    lightgoldenrod3(179),
    tan(180),
    mistyrose3(181),
    thistle3(182),
    plum2(183),
    yellow3a(184),
    khaki3(185),
    lightgoldenrod2(186),
    lightyellow3(187),
    grey84(188),
    lightsteelblue1(189),
    yellow2(190),
    darkolivegreen1(191),
    darkolivegreen1a(192),
    darkseagreen1a(193),
    honeydew2(194),
    lightcyan1(195),
    red1(196),
    deeppink2(197),
    deeppink1(198),
    deeppink1a(199),
    magenta2a(200),
    magenta1(201),
    orangered1(202),
    indianred1(203),
    indianred1a(204),
    hotpink(205),
    hotpinka(206),
    mediumorchid1a(207),
    darkorange(PacketOpcodes.PlatformStartRouteNotify),
    salmon1(PacketOpcodes.PlatformStopRouteNotify),
    lightcoral(PacketOpcodes.SceneForceUnlockNotify),
    palevioletred1(PacketOpcodes.ExitSceneWeatherAreaNotify),
    orchid2(PacketOpcodes.SceneKickPlayerReq),
    orchid1(PacketOpcodes.AddSeenMonsterNotify),
    orange1(PacketOpcodes.SetSceneWeatherAreaReq),
    sandybrown(215),
    lightsalmon1(216),
    lightpink1(PacketOpcodes.SceneEntityDrownReq),
    pink1(PacketOpcodes.BackMyWorldRsp),
    plum1(PacketOpcodes.SceneInitFinishReq),
    gold1(220),
    lightgoldenrod2a(PacketOpcodes.ClientTransmitReq),
    lightgoldenrod2b(PacketOpcodes.ClientTransmitRsp),
    navajowhite1(PacketOpcodes.LevelupCityReq),
    mistyrose1(PacketOpcodes.WorldPlayerLocationNotify),
    thistle1(PacketOpcodes.GetScenePointRsp),
    yellow1(PacketOpcodes.SealBattleBeginNotify),
    lightgoldenrod1(PacketOpcodes.SceneAvatarStaminaStepRsp),
    khaki1(PacketOpcodes.AllSeenMonsterNotify),
    wheat1(PacketOpcodes.WorldPlayerReviveReq),
    cornsilk1(PacketOpcodes.LeaveSceneReq),
    grey100(PacketOpcodes.SceneKickPlayerRsp),
    grey3(PacketOpcodes.EnterSceneDoneReq),
    grey7(233),
    grey11(PacketOpcodes.EntityForceSyncReq),
    grey15(PacketOpcodes.ExecuteGadgetLuaReq),
    grey19(PacketOpcodes.ClientPauseNotify),
    grey23(237),
    grey27(PacketOpcodes.HitClientTrivialNotify),
    grey30(PacketOpcodes.SceneEntityMoveNotify),
    grey35(PacketOpcodes.ExecuteGadgetLuaRsp),
    grey39(PacketOpcodes.PlayerEnterSceneInfoNotify),
    grey42(242),
    grey46(PacketOpcodes.SceneEntityAppearNotify),
    grey50(PacketOpcodes.GetSceneAreaRsp),
    grey54(245),
    grey58(PacketOpcodes.EnterWorldAreaReq),
    grey62(247),
    grey66(PacketOpcodes.ScenePlayerLocationNotify),
    grey70(PacketOpcodes.BeginCameraSceneLookNotify),
    grey74(250),
    grey78(PacketOpcodes.EnterSceneReadyRsp),
    grey82(PacketOpcodes.PersonalSceneJumpReq),
    grey85(PacketOpcodes.ScenePlayerInfoNotify),
    grey89(254),
    grey93(255);
    
    public final int code;

    StyleColor(int code) {
        this.code = code;
    }
}
