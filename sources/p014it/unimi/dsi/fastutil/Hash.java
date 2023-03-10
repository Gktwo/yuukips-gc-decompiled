package p014it.unimi.dsi.fastutil;

import emu.grasscutter.net.packet.PacketOpcodes;

/* renamed from: it.unimi.dsi.fastutil.Hash */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/Hash.class */
public interface Hash {
    public static final int DEFAULT_INITIAL_SIZE = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public static final float FAST_LOAD_FACTOR = 0.5f;
    public static final float VERY_FAST_LOAD_FACTOR = 0.25f;
    @Deprecated
    public static final int DEFAULT_GROWTH_FACTOR = 16;
    @Deprecated
    public static final byte FREE = 0;
    @Deprecated
    public static final byte OCCUPIED = -1;
    @Deprecated
    public static final byte REMOVED = 1;
    @Deprecated
    public static final int[] PRIMES;

    /* renamed from: it.unimi.dsi.fastutil.Hash$Strategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/Hash$Strategy.class */
    public interface Strategy<K> {
        int hashCode(K k);

        boolean equals(K k, K k2);
    }

    static {
        int[] iArr = new int[PacketOpcodes.GetQuestLackingResourceReq];
        iArr[0] = 3;
        iArr[1] = 3;
        iArr[2] = 3;
        iArr[3] = 3;
        iArr[4] = 3;
        iArr[5] = 3;
        iArr[6] = 3;
        iArr[7] = 3;
        iArr[8] = 3;
        iArr[9] = 3;
        iArr[10] = 5;
        iArr[11] = 5;
        iArr[12] = 5;
        iArr[13] = 5;
        iArr[14] = 5;
        iArr[15] = 5;
        iArr[16] = 7;
        iArr[17] = 7;
        iArr[18] = 7;
        iArr[19] = 7;
        iArr[20] = 7;
        iArr[21] = 7;
        iArr[22] = 7;
        iArr[23] = 7;
        iArr[24] = 7;
        iArr[25] = 7;
        iArr[26] = 7;
        iArr[27] = 13;
        iArr[28] = 13;
        iArr[29] = 13;
        iArr[30] = 13;
        iArr[31] = 13;
        iArr[32] = 13;
        iArr[33] = 13;
        iArr[34] = 13;
        iArr[35] = 19;
        iArr[36] = 19;
        iArr[37] = 19;
        iArr[38] = 19;
        iArr[39] = 19;
        iArr[40] = 19;
        iArr[41] = 19;
        iArr[42] = 19;
        iArr[43] = 19;
        iArr[44] = 19;
        iArr[45] = 19;
        iArr[46] = 19;
        iArr[47] = 31;
        iArr[48] = 31;
        iArr[49] = 31;
        iArr[50] = 31;
        iArr[51] = 31;
        iArr[52] = 31;
        iArr[53] = 31;
        iArr[54] = 43;
        iArr[55] = 43;
        iArr[56] = 43;
        iArr[57] = 43;
        iArr[58] = 43;
        iArr[59] = 43;
        iArr[60] = 43;
        iArr[61] = 43;
        iArr[62] = 61;
        iArr[63] = 61;
        iArr[64] = 61;
        iArr[65] = 61;
        iArr[66] = 61;
        iArr[67] = 73;
        iArr[68] = 73;
        iArr[69] = 73;
        iArr[70] = 73;
        iArr[71] = 73;
        iArr[72] = 73;
        iArr[73] = 73;
        iArr[74] = 103;
        iArr[75] = 103;
        iArr[76] = 109;
        iArr[77] = 109;
        iArr[78] = 109;
        iArr[79] = 109;
        iArr[80] = 109;
        iArr[81] = 139;
        iArr[82] = 139;
        iArr[83] = 151;
        iArr[84] = 151;
        iArr[85] = 151;
        iArr[86] = 151;
        iArr[87] = 181;
        iArr[88] = 181;
        iArr[89] = 193;
        iArr[90] = 199;
        iArr[91] = 199;
        iArr[92] = 199;
        iArr[93] = 229;
        iArr[94] = 241;
        iArr[95] = 241;
        iArr[96] = 241;
        iArr[97] = 271;
        iArr[98] = 283;
        iArr[99] = 283;
        iArr[100] = 313;
        iArr[101] = 313;
        iArr[102] = 313;
        iArr[103] = 349;
        iArr[104] = 349;
        iArr[105] = 349;
        iArr[106] = 349;
        iArr[107] = 421;
        iArr[108] = 433;
        iArr[109] = 463;
        iArr[110] = 463;
        iArr[111] = 463;
        iArr[112] = 523;
        iArr[113] = 523;
        iArr[114] = 571;
        iArr[115] = 601;
        iArr[116] = 619;
        iArr[117] = 661;
        iArr[118] = 661;
        iArr[119] = 661;
        iArr[120] = 661;
        iArr[121] = 661;
        iArr[122] = 823;
        iArr[123] = 859;
        iArr[124] = 883;
        iArr[125] = 883;
        iArr[126] = 883;
        iArr[127] = 1021;
        iArr[128] = 1063;
        iArr[129] = 1093;
        iArr[130] = 1153;
        iArr[131] = 1153;
        iArr[132] = 1231;
        iArr[133] = 1321;
        iArr[134] = 1321;
        iArr[135] = 1429;
        iArr[136] = 1489;
        iArr[137] = 1489;
        iArr[138] = 1621;
        iArr[139] = 1699;
        iArr[140] = 1789;
        iArr[141] = 1873;
        iArr[142] = 1951;
        iArr[143] = 2029;
        iArr[144] = 2131;
        iArr[145] = 2143;
        iArr[146] = 2311;
        iArr[147] = 2383;
        iArr[148] = 2383;
        iArr[149] = 2593;
        iArr[150] = 2731;
        iArr[151] = 2803;
        iArr[152] = 3001;
        iArr[153] = 3121;
        iArr[154] = 3259;
        iArr[155] = 3391;
        iArr[156] = 3583;
        iArr[157] = 3673;
        iArr[158] = 3919;
        iArr[159] = 4093;
        iArr[160] = 4273;
        iArr[161] = 4423;
        iArr[162] = 4651;
        iArr[163] = 4801;
        iArr[164] = 5023;
        iArr[165] = 5281;
        iArr[166] = 5521;
        iArr[167] = 5743;
        iArr[168] = 5881;
        iArr[169] = 6301;
        iArr[170] = 6571;
        iArr[171] = 6871;
        iArr[172] = 7129;
        iArr[173] = 7489;
        iArr[174] = 7759;
        iArr[175] = 8089;
        iArr[176] = 8539;
        iArr[177] = 8863;
        iArr[178] = 9283;
        iArr[179] = 9721;
        iArr[180] = 10141;
        iArr[181] = 10531;
        iArr[182] = 11071;
        iArr[183] = 11551;
        iArr[184] = 12073;
        iArr[185] = 12613;
        iArr[186] = 13009;
        iArr[187] = 13759;
        iArr[188] = 14323;
        iArr[189] = 14869;
        iArr[190] = 15649;
        iArr[191] = 16363;
        iArr[192] = 17029;
        iArr[193] = 17839;
        iArr[194] = 18541;
        iArr[195] = 19471;
        iArr[196] = 20233;
        iArr[197] = 21193;
        iArr[198] = 22159;
        iArr[199] = 23059;
        iArr[200] = 24181;
        iArr[201] = 25171;
        iArr[202] = 26263;
        iArr[203] = 27541;
        iArr[204] = 28753;
        iArr[205] = 30013;
        iArr[206] = 31321;
        iArr[207] = 32719;
        iArr[208] = 34213;
        iArr[209] = 35731;
        iArr[210] = 37309;
        iArr[211] = 38923;
        iArr[212] = 40639;
        iArr[213] = 42463;
        iArr[214] = 44281;
        iArr[215] = 46309;
        iArr[216] = 48313;
        iArr[217] = 50461;
        iArr[218] = 52711;
        iArr[219] = 55051;
        iArr[220] = 57529;
        iArr[221] = 60091;
        iArr[222] = 62299;
        iArr[223] = 65521;
        iArr[224] = 68281;
        iArr[225] = 71413;
        iArr[226] = 74611;
        iArr[227] = 77713;
        iArr[228] = 81373;
        iArr[229] = 84979;
        iArr[230] = 88663;
        iArr[231] = 92671;
        iArr[232] = 96739;
        iArr[233] = 100801;
        iArr[234] = 105529;
        iArr[235] = 109849;
        iArr[236] = 115021;
        iArr[237] = 120079;
        iArr[238] = 125509;
        iArr[239] = 131011;
        iArr[240] = 136861;
        iArr[241] = 142873;
        iArr[242] = 149251;
        iArr[243] = 155863;
        iArr[244] = 162751;
        iArr[245] = 169891;
        iArr[246] = 177433;
        iArr[247] = 185071;
        iArr[248] = 193381;
        iArr[249] = 202129;
        iArr[250] = 211063;
        iArr[251] = 220021;
        iArr[252] = 229981;
        iArr[253] = 240349;
        iArr[254] = 250969;
        iArr[255] = 262111;
        iArr[256] = 273643;
        iArr[257] = 285841;
        iArr[258] = 298411;
        iArr[259] = 311713;
        iArr[260] = 325543;
        iArr[261] = 339841;
        iArr[262] = 355009;
        iArr[263] = 370663;
        iArr[264] = 386989;
        iArr[265] = 404269;
        iArr[266] = 422113;
        iArr[267] = 440809;
        iArr[268] = 460081;
        iArr[269] = 480463;
        iArr[270] = 501829;
        iArr[271] = 524221;
        iArr[272] = 547399;
        iArr[273] = 571603;
        iArr[274] = 596929;
        iArr[275] = 623353;
        iArr[276] = 651019;
        iArr[277] = 679909;
        iArr[278] = 709741;
        iArr[279] = 741343;
        iArr[280] = 774133;
        iArr[281] = 808441;
        iArr[282] = 844201;
        iArr[283] = 881539;
        iArr[284] = 920743;
        iArr[285] = 961531;
        iArr[286] = 1004119;
        iArr[287] = 1048573;
        iArr[288] = 1094923;
        iArr[289] = 1143283;
        iArr[290] = 1193911;
        iArr[291] = 1246963;
        iArr[292] = 1302181;
        iArr[293] = 1359733;
        iArr[294] = 1420039;
        iArr[295] = 1482853;
        iArr[296] = 1548541;
        iArr[297] = 1616899;
        iArr[298] = 1688413;
        iArr[299] = 1763431;
        iArr[300] = 1841293;
        iArr[301] = 1922773;
        iArr[302] = 2008081;
        iArr[303] = 2097133;
        iArr[304] = 2189989;
        iArr[305] = 2286883;
        iArr[306] = 2388163;
        iArr[307] = 2493853;
        iArr[308] = 2604013;
        iArr[309] = 2719669;
        iArr[310] = 2840041;
        iArr[311] = 2965603;
        iArr[312] = 3097123;
        iArr[313] = 3234241;
        iArr[314] = 3377191;
        iArr[315] = 3526933;
        iArr[316] = 3682363;
        iArr[317] = 3845983;
        iArr[318] = 4016041;
        iArr[319] = 4193803;
        iArr[320] = 4379719;
        iArr[321] = 4573873;
        iArr[322] = 4776223;
        iArr[323] = 4987891;
        iArr[324] = 5208523;
        iArr[325] = 5439223;
        iArr[326] = 5680153;
        iArr[327] = 5931313;
        iArr[328] = 6194191;
        iArr[329] = 6468463;
        iArr[330] = 6754879;
        iArr[331] = 7053331;
        iArr[332] = 7366069;
        iArr[333] = 7692343;
        iArr[334] = 8032639;
        iArr[335] = 8388451;
        iArr[336] = 8759953;
        iArr[337] = 9147661;
        iArr[338] = 9552733;
        iArr[339] = 9975193;
        iArr[340] = 10417291;
        iArr[341] = 10878619;
        iArr[342] = 11360203;
        iArr[343] = 11863153;
        iArr[344] = 12387841;
        iArr[345] = 12936529;
        iArr[346] = 13509343;
        iArr[347] = 14107801;
        iArr[348] = 14732413;
        iArr[349] = 15384673;
        iArr[350] = 16065559;
        iArr[351] = 16777141;
        iArr[352] = 17519893;
        iArr[353] = 18295633;
        iArr[354] = 19105483;
        iArr[355] = 19951231;
        iArr[356] = 20834689;
        iArr[357] = 21757291;
        iArr[358] = 22720591;
        iArr[359] = 23726449;
        iArr[360] = 24776953;
        iArr[361] = 25873963;
        iArr[362] = 27018853;
        iArr[363] = 28215619;
        iArr[364] = 29464579;
        iArr[365] = 30769093;
        iArr[366] = 32131711;
        iArr[367] = 33554011;
        iArr[368] = 35039911;
        iArr[369] = 36591211;
        iArr[370] = 38211163;
        iArr[371] = 39903121;
        iArr[372] = 41669479;
        iArr[373] = 43514521;
        iArr[374] = 45441199;
        iArr[375] = 47452879;
        iArr[376] = 49553941;
        iArr[377] = 51747991;
        iArr[378] = 54039079;
        iArr[379] = 56431513;
        iArr[380] = 58930021;
        iArr[381] = 61539091;
        iArr[382] = 64263571;
        iArr[383] = 67108669;
        iArr[384] = 70079959;
        iArr[385] = 73182409;
        iArr[386] = 76422793;
        iArr[387] = 79806229;
        iArr[388] = 83339383;
        iArr[389] = 87029053;
        iArr[390] = 90881083;
        iArr[391] = 94906249;
        iArr[392] = 99108043;
        iArr[393] = 103495879;
        iArr[394] = 108077731;
        iArr[395] = 112863013;
        iArr[396] = 117860053;
        iArr[397] = 123078019;
        iArr[398] = 128526943;
        iArr[399] = 134217439;
        iArr[400] = 140159911;
        iArr[401] = 146365159;
        iArr[402] = 152845393;
        iArr[403] = 159612601;
        iArr[404] = 166679173;
        iArr[405] = 174058849;
        iArr[406] = 181765093;
        iArr[407] = 189812341;
        iArr[408] = 198216103;
        iArr[409] = 206991601;
        iArr[410] = 216156043;
        iArr[411] = 225726379;
        iArr[412] = 235720159;
        iArr[413] = 246156271;
        iArr[414] = 257054491;
        iArr[415] = 268435009;
        iArr[416] = 280319203;
        iArr[417] = 292730833;
        iArr[418] = 305691181;
        iArr[419] = 319225021;
        iArr[420] = 333358513;
        iArr[421] = 348117151;
        iArr[422] = 363529759;
        iArr[423] = 379624279;
        iArr[424] = 396432481;
        iArr[425] = 413983771;
        iArr[426] = 432312511;
        iArr[427] = 451452613;
        iArr[428] = 471440161;
        iArr[429] = 492312523;
        iArr[430] = 514109251;
        iArr[431] = 536870839;
        iArr[432] = 560640001;
        iArr[433] = 585461743;
        iArr[434] = 611382451;
        iArr[435] = 638450569;
        iArr[436] = 666717199;
        iArr[437] = 696235363;
        iArr[438] = 727060069;
        iArr[439] = 759249643;
        iArr[440] = 792864871;
        iArr[441] = 827967631;
        iArr[442] = 864625033;
        iArr[443] = 902905501;
        iArr[444] = 942880663;
        iArr[445] = 984625531;
        iArr[446] = 1028218189;
        iArr[447] = 1073741719;
        iArr[448] = 1121280091;
        iArr[449] = 1170923713;
        iArr[450] = 1222764841;
        iArr[451] = 1276901371;
        iArr[452] = 1333434301;
        iArr[453] = 1392470281;
        iArr[454] = 1454120779;
        iArr[455] = 1518500173;
        iArr[456] = 1585729993;
        iArr[457] = 1655935399;
        iArr[458] = 1729249999;
        iArr[459] = 1805811253;
        iArr[460] = 1885761133;
        iArr[461] = 1969251079;
        iArr[462] = 2056437379;
        iArr[463] = 2147482951;
        PRIMES = iArr;
    }
}
