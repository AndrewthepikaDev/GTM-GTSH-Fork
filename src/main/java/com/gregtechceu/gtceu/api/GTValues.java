package com.gregtechceu.gtceu.api;

import net.minecraft.util.RandomSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.function.BooleanSupplier;
import java.util.function.IntFunction;

import static net.minecraft.ChatFormatting.*;

/**
 * Made for static imports, this Class is just a Helper.
 */
public class GTValues {

    /**
     * <p/>
     * This is worth exactly one normal Item.
     * This Constant can be divided by many commonly used Numbers such as
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 24, ... 64 or 81
     * without loosing precision and is for that reason used as Unit of Amount.
     * But it is also small enough to be multiplied with larger Numbers.
     * <p/>
     * This is used to determine the amount of Material contained inside a prefixed Ore.
     * For example Nugget = M / 9 as it contains out of 1/9 of an Ingot.
     */
    public static final long M = 3628800;

    /**
     * Renamed from "FLUID_MATERIAL_UNIT" to just "L"
     * <p/>
     * Fluid per Material Unit (Prime Factors: 3 * 3 * 2 * 2 * 2 * 2)
     */
    public static final int L = 144;
    public static final RandomSource RNG = RandomSource.createThreadSafe();

    // shortcut for various lengths of time in ticks
    public static final long SECONDS = 20;
    public static final long MINUTES = 60 * SECONDS;
    public static final long HOURS = 60 * MINUTES;
    public static final long DAYS = 24 * HOURS;
    public static final long WEEKS = 7 * DAYS;
    public static final long MONTHS = 30 * DAYS;
    public static final long YEARS = 365 * DAYS;

    /**
     * The Item WildCard Tag. Even shorter than the "-1" of the past
     */

    // public static final short W = OreDictionary.WILDCARD_VALUE;

    /** Current time on the Client. Will always be zero on the server. */
    public static long CLIENT_TIME = 0;

    /**
     * The Voltage Tiers. Use this Array instead of the old named Voltage Variables
     */
    public static final long[] V = { 8, 32, 128, 512, 2048, 8192, 32768, 131072, 524288, 2097152, 8388608,
            33554432, 134217728, 536870912, 2147483648L, 8589934592L, 34359738368L, 137438953472L, 549755813888L,
            2199023255552L, 8796093022208L, 35184372088832L, 140737488355328L, 562949953421312L, 2251799813685248L
    };

    /**
     * The Voltage Tiers divided by 2.
     */
    public static final int[] VH = { 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216,
            67108864, 268435456, 1073741824, 4294967296L, 17179869184L, 68719476736L, 274877906944L, 1099511627776L,
            4398046511104L, 17592186044416L, 70368744177664L, 281474976710656L, 1125899906842624L};

    /**
     * The Voltage Tiers adjusted for cable loss. Use this for recipe EU/t to avoid full-amp recipes
     */
    public static final int[] VA = { 7, 30, 120, 480, 1920, 7680, 30720, 122880, 491520, 1966080, 7864320,
            31457280, 125829120, 503316480, 2013265920, 8053063680L, 32212254720L, 128849018880L, 515396075520L,
            2061584302080L, 8246337208320L, 32985348833280L, 131941395333120L, 527765581332480L, 2111062325329920L};

    /**
     * The Voltage Tiers adjusted for cable loss, divided by 2.
     */
    public static final int[] VHA = { 3, 15, 60, 240, 960, 3840, 15360, 61440, 245760, 983040, 3932160, 15728640,
            62914560, 251658240, 1006632960, 4026531840L, 16106127360L, 64424509440L, 257698037760L, 1030792151040L,
            4123168604160L, 16492674416640L, 65970697666560L, 263882790666240L, 1055531162664960L};

    /**
     * The Voltage Tiers. Use this Array instead of the old named Voltage Variables
     */
    public static final long[] VEX = { 8, 32, 128, 512, 2048, 8192, 32768, 131072, 524288, 2097152, 8388608,
            33554432, 134217728, 536870912, 2147483648L, 8589934592L, 34359738368L, 137438953472L, 549755813888L,
            2199023255552L, 8796093022208L, 35184372088832L, 140737488355328L, 562949953421312L, 2251799813685248L,
            9007199254740992L, 36028797018963968L, 144115188075855872L, 576460752303423488L, 2305843009213693952L,
            Long.MAX_VALUE };

    public static final int ULV = 0;
    public static final int LV = 1;
    public static final int MV = 2;
    public static final int HV = 3;
    public static final int EV = 4;
    public static final int IV = 5;
    public static final int LuV = 6;
    public static final int ZPM = 7;
    public static final int UV = 8;
    public static final int UHV = 9;
    public static final int UEV = 10;
    public static final int UIV = 11;
    public static final int UXV = 12;
    public static final int OpV = 13;
    public static final int MAX = 14;
    public static final int EpV = 15;
    public static final int LgV = 16;
    public static final int MyV = 17;
    public static final int ErV = 18;
    public static final int VV = 19;
    public static final int ElV = 20;
    public static final int CV = 21;
    public static final int EtV = 22;
    public static final int AbV = 23;
    public static final int FV = 24;
    public static final int MAX_TRUE = 30;

    public static final int[] ALL_TIERS = new int[] { ULV, LV, MV, HV, EV, IV, LuV, ZPM, UV, UHV, UEV, UIV, UXV, OpV,
            MAX, EpV, LgV, MyV, ErV, VV, ElV, CV, EtV, AbV, FV };
    public static final int TIER_COUNT = ALL_TIERS.length;

    public static int[] tiersBetween(int minInclusive, int maxInclusive) {
        return Arrays.stream(ALL_TIERS).dropWhile(tier -> tier < minInclusive).takeWhile(tier -> tier <= maxInclusive)
                .toArray();
    }

    public static final String MODID_TOP = "theoneprobe",
            MODID_JEI = "jei",
            MODID_REI = "roughlyenoughitems",
            MODID_EMI = "emi",
            MODID_APPENG = "ae2",
            MODID_KUBEJS = "kubejs",
            MODID_IRIS = "iris",
            MODID_OCULUS = "oculus",
            MODID_SODIUM = "sodium",
            MODID_RUBIDIUM = "rubidium",
            MODID_EMBEDDIUM = "embeddium",
            MODID_CREATE = "create",
            MODID_CURIOS = "curios",
            MODID_AE2WTLIB = "ae2wtlib",
            MODID_SHIMMER = "shimmer",
            MODID_MODERNFIX = "modernfix",
            MODID_JOURNEYMAP = "journeymap",
            MODID_XAEROS_MINIMAP = "xaerominimap",
            MODID_XAEROS_WORLDMAP = "xaeroworldmap",
            MODID_FTB_CHUNKS = "ftbchunks",
            MODID_JAVD = "javd",
            MODID_FTB_TEAMS = "ftbteams",
            MODID_ARGONAUTS = "argonauts",
            MODID_HERACLES = "heracles",
            MODID_GAMESTAGES = "gamestages",
            MODID_FTB_QUEST = "ftbquests",
            MODID_CCTWEAKED = "computercraft",
            MODID_ENDERIO = "enderio",
            MODID_ENSORCELLATION = "ensorcellation";

    /**
     * Spray painting compat modids
     */
    public static final String MODID_TINTED = "tinted";

    /**
     * The short names for the voltages, used for registration primarily
     */
    public static final String[] VN = new String[] { "ULV", "LV", "MV", "HV", "EV", "IV", "LuV", "ZPM", "UV", "UHV",
            "UEV", "UIV", "UXV", "OpV", "MAX", "EpV", "LgV", "MyV", "ErV", "VV", "ElV", "CV", "EtV", "AbV", "FV" };

    public static final IntFunction<String> FV_PLUS_FORMAT = (value) -> "" + RED + BOLD + "F" +
            GREEN + BOLD + "V" +
            BLUE + BOLD + "+" +
            YELLOW + BOLD + value;

    /**
     * The short names for the voltages, formatted for text
     */
    public static final String[] VNF = new String[] {
            DARK_GRAY + "ULV",
            GRAY + "LV",
            AQUA + "MV",
            GOLD + "HV",
            DARK_PURPLE + "EV",
            BLUE + "IV",
            LIGHT_PURPLE + "LuV",
            RED + "ZPM",
            DARK_AQUA + "UV",
            DARK_RED + "UHV",
            GREEN + "UEV",
            DARK_GREEN + "UIV",
            YELLOW + "UXV",
            BLUE.toString() + BOLD + "OpV",
            RED.toString() + BOLD + "MAX",
            PURPLE.toString() + BOLD + "EpV",
            YELLOW.toString() + BOLD + "LgV",
            GOLD.toString() + BOLD + "MyV",
            GRAY.toString() + BOLD + "ErV",
            DARK_GRAY.toString() + BOLD + "VV",
            BLACK.toString() + BOLD + "ElV",
            AQUA.toString() + BOLD + "CV",
            GREEN.toString() + BOLD + "EtV",
            DARK_GREEN.toString() + BOLD + "AbV",
            WHITE.toString() + BOLD + "FV",
            FV_PLUS_FORMAT.apply(1),
            FV_PLUS_FORMAT.apply(2),
            FV_PLUS_FORMAT.apply(3),
            FV_PLUS_FORMAT.apply(4),
            FV_PLUS_FORMAT.apply(5),
            FV_PLUS_FORMAT.apply(6),
    };

    public static final String[] VCF = new String[] {
            DARK_GRAY.toString(),
            GRAY.toString(),
            AQUA.toString(),
            GOLD.toString(),
            DARK_PURPLE.toString(),
            BLUE.toString(),
            LIGHT_PURPLE.toString(),
            RED.toString(),
            DARK_AQUA.toString(),
            DARK_RED.toString(),
            GREEN.toString(),
            DARK_GREEN.toString(),
            YELLOW.toString(),
            BLUE.toString() + BOLD.toString(),
            RED.toString() + BOLD.toString(),
            PURPLE.toString() + BOLD.toString(),
            YELLOW.toString() + BOLD.toString(),
            GOLD.toString() + BOLD.toString(),
            GRAY.toString() + BOLD.toString(),
            DARK_GRAY.toString() + BOLD.toString(),
            BLACK.toString() + BOLD.toString(),
            AQUA.toString() + BOLD.toString(),
            GREEN.toString() + BOLD.toString(),
            DARK_GREEN.toString() + BOLD.toString(),
            WHITE.toString() + BOLD.toString()};

    public static final String[] VLVH = new String[] {
            "Primitive", // not doing the gray color for these first two because it looks weird
            "Basic",
            AQUA + "Advanced",
            GOLD + "Advanced",
            DARK_PURPLE + "Advanced",
            BLUE + "Elite",
            LIGHT_PURPLE + "Elite",
            RED + "Elite",
            DARK_AQUA + "Ultimate",
            DARK_RED + "Epic",
            GREEN + "Epic",
            DARK_GREEN + "Epic",
            YELLOW + "Epic",
            BLUE.toString() + BOLD + "Legendary",
            RED.toString() + BOLD + "Legendary",
            PURPLE.toString() + BOLD + "Legendary",
            YELLOW.toString() + BOLD + "Legendary",
            GOLD.toString() + BOLD + "Mythic",
            GRAY.toString() + BOLD + "Mythic",
            DARK_GRAY.toString() + BOLD + "Mythic",
            BLACK.toString() + BOLD + "Mythic",
            AQUA.toString() + BOLD + "Absurd",
            GREEN.toString() + BOLD + "Absurd",
            DARK_GREEN.toString() + BOLD + "Absurd",
            WHITE.toString() + BOLD + "Final" };

    public static final String[] VLVT = new String[] {
            "" + RESET,
            "" + RESET,
            "" + RESET,
            "II" + RESET,
            "III" + RESET,
            "" + RESET,
            "II" + RESET,
            "III" + RESET,
            "" + RESET,
            "" + RESET,
            "II" + RESET,
            "III" + RESET,
            "IV" + RESET,
            "" + RESET,
            "II" + RESET,
            "III" + RESET,
            "IV" + RESET,
            "" + RESET,
            "II" + RESET,
            "III" + RESET,
            "IV" + RESET,
            "" + RESET,
            "II" + RESET,
            "III" + RESET,
            "" + RESET,};

    public static final String[] LVT = new String[] {
            "",
            "I",
            "II",
            "III",
            "IV",
            "V",
            "VI",
            "VII",
            "VIII",
            "IX",
            "X",
            "XI",
            "XII",
            "XIII",
            "XIV",
            "XV",
            "XVI",
            "XVII",
            "XVIII",
            "XIX",
            "XX",
            "XXI",
            "XXII",
            "XXIII",
            "XXIV"
    };

    /**
     * Color values for the voltages
     */
    public static final int[] VC = new int[] { 0xC80000, 0xDCDCDC, 0xFF6400, 0xFFFF1E, 0x808080, 0xF0F0F5, 0xE99797,
            0x7EC3C4, 0x7EB07E, 0xBF74C0, 0x0B5CFE, 0x914E91, 0x488748, 0x8C0000, 0x2828F5, 0xD67FFF, 0xFFE97F, 0xFFB27F,
            0xA0A0A0, 0x404040, 0x202020, 0x3F7F7F, 0x4CFF00, 0x267F00, 0xFFFFFF};

    // Main colour for each tier
    public static final int[] VCM = new int[] {
            DARK_GRAY.getColor(),
            GRAY.getColor(),
            AQUA.getColor(),
            GOLD.getColor(),
            DARK_PURPLE.getColor(),
            BLUE.getColor(),
            LIGHT_PURPLE.getColor(),
            RED.getColor(),
            DARK_AQUA.getColor(),
            DARK_RED.getColor(),
            GREEN.getColor(),
            DARK_GREEN.getColor(),
            YELLOW.getColor(),
            BLUE.getColor(),
            RED.getColor(),
            PURPLE.getColor(),
            YELLOW.getColor(),
            GOLD.getColor(),
            GRAY.getColor(),
            DARK_GRAY.getColor(),
            BLACK.getColor(),
            AQUA.getColor(),
            GREEN.getColor(),
            DARK_GREEN.getColor(),
            WHITE.getColor()
    };

    // Main color for steam machines
    public static final int VC_LP_STEAM = 0xBB8E53;
    public static final int VC_HP_STEAM = 0x79756F;

    /**
     * The long names for the voltages
     */
    public static final String[] VOLTAGE_NAMES = new String[] { "Ultra Low Voltage", "Low Voltage", "Medium Voltage",
            "High Voltage", "Extreme Voltage", "Insane Voltage", "Ludicrous Voltage", "ZPM Voltage", "Ultimate Voltage",
            "Ultra High Voltage", "Ultra Excessive Voltage", "Ultra Immense Voltage", "Ultra Extreme Voltage",
            "Overpowered Voltage", "Maximum Voltage", "Epic Voltage", "Legendary Voltage", "Mythic Voltage",
            "Error Voltage", "Void Voltage", "Eldritch Voltage", "Comical Voltage", "Eternal Voltage", "Absolute Voltage",
            "Final Voltage"};

    /**
     * Used to tell if any high-tier machine (UHV+) was registered.
     */
    public static boolean HT = false;

    public static BooleanSupplier FOOLS = () -> {
        var now = LocalDate.now();
        return now.getMonth() == Month.APRIL && now.getDayOfMonth() == 1;
    };

    public static BooleanSupplier XMAS = () -> {
        var now = LocalDate.now();
        return now.getMonth() == Month.DECEMBER && (now.getDayOfMonth() == 24 || now.getDayOfMonth() == 25);
    };

    public static final String CUSTOM_TAG_SOURCE = "GTCEu Custom Tags";
}
