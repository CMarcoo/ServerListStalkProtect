/*
 *     ServerListStalkProtect - Protect Your Server from Server List Stalkers
 *     Copyright © 2024  CMarco
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package top.cmarco.serverliststalkprotect;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public final class Usernames {

    private static final ThreadLocalRandom RAND = ThreadLocalRandom.current();

    public static final String[] MINECRAFT_USERNAMES = {
            "lockBusterMaster", "DiamondDestroyer", "EnderWarrior_5", "TerraformTitan", "CraftingGenius",
            "UltraNavigator", "RedstoneRuler", "CrustyCrusher3", "PixelPioneer", "IronInquisitor",
            "GoldGoliath", "ObsidianOverlord", "WitherWrecker", "ZombieZapper", "SkeletalSlayer",
            "BedrockBomber", "LavaLiberator", "EmeraldGuardian", "MaritimePrince", "BlocksQueen",
            "BiomeBender", "PortalPatroller", "GhastGuzzler", "TNTTactician", "SlimeSquasher",
            "PickaxePusher", "NetheriteKnight", "CobblestoneKing", "SilkyShuffler", "EndstoneEmperor",
            "DrownedDefeater", "VillagerVanguard", "FarmingFury", "RaiderRipper", "RavineRunner",
            "CaveCrafter", "BeaconBlazer", "MagmaMonarch", "DungeonDominator", "RubericRider",
            "EndEyeExplorer", "BlazeBattler", "SpiderSquisher", "WitchWhacker", "EnchantmentEmissary",
            "OceanOpener", "BlockTosser3", "EarthShaker", "GuardianGrinder", "StriderStriker",
            "LoomLord", "CartographerCaptain", "FletcherFanatic", "SmithingSovereign", "BrewerBaron",
            "AnvilAdmiral", "FurnaceFueled", "ViscousConqueror", "RedstoneReaper", "LectorLegend",
            "CakeCreator", "PotionProducer", "TotemTaker", "ToolsandDigs", "FireworkFan",
            "RecordRocker", "SnowballSniper", "ElytraEagle", "FireChargeFighter", "LeadLancer",
            "NameTagNoble", "HeartOfTheSeaHerald", "TridentTruther", "NetherStarNinja", "SoulSandSummoner",
            "SaddleSummoner", "IronGolemInvoker", "TurtleMaster", "DolphinDominator", "LynxOfLapis",
            "CoalConqueror", "IronEagle", "TopazTitan", "SapphireSovereign", "RubyRider", "OnyxOverlord",
            "DiamondDynamo", "PearlProtector", "JadeJester", "BirdQuarrier", "FlintFinder",
            "CoralCrafter", "LapisLynx", "MagmaMaven", "NetheriteNoble", "ObsidianOgre",
            "PrismarinePirate", "MineRebel", "StoneSlayer", "TerracottaTamer", "WoolWarrior",
            "ZirconZealot", "CrystalCutter", "GemstoneGuardian", "JewelJuggler", "MineralMaster",
            "OreOverseer", "PebblePrince", "RockRider", "SandstoneSoldier", "AzureAdventurer",
            "BoulderBender", "ChiselChampion", "DrillDominator", "GravelGrinder", "MasonryMaster",
            "PickaxePro", "QuarryQueen", "SlateSlayer", "TopsoilTitan", "BlockBender",
            "CubeConqueror", "PixelPurist", "VoxelsVictor", "WireframeWarrior", "DigitalDynamo",
            "BitmapBaron", "PolygonPrince", "RenderReaper", "SpriteSlayer", "BitBomber",
            "DataDasher", "GlitchGuardian", "PacketPirate", "ByteBattler", "FirewallFighter",
            "MalwareMage", "RootkitReaper2", "SpywareSlayer", "TrojanTrasher", "DebugDominator",
            "KernelKnight", "LogicLancer", "ScriptSoldier", "ThreadThresher", "VectorVanguard",
            "CubePharaoh", "VoxelViking", "CipherCenturion", "ByteBuccaneer"
    };

    public static final String[] HARDCODED_UUIDS = {
            "069a79f4-44e9-4726-a5be-fca90e38aaf5",
            "b0a88a4c-8b2e-4e3c-97e1-5a8015b1e01b",
            "93e7a48d-9a26-4c69-a4e3-d1f2b98e01b4",
            "837b8f6f-cfea-495b-a2e6-cb4062cfcc0d",
            "4f2a6c53-0e7c-4a43-a0bb-3cc2abf49e12",
            "16b5d8e0-cb6e-45d1-98c2-7a3ed20a2ed1",
            "d09c21b3-0723-4327-bf8c-57532554dca7",
            "f8b865f6-3f2f-41b8-8a64-4502821c86e6",
            "6173a89a-29d9-4e5b-8304-1f703ff0f92f",
            "c7e5bd8b-e60e-4ab5-9e55-2b6ba9dfaf0f",
            "3b3e5b5e-c001-418b-b6ef-7c1f85b2b25f",
            "f75fe1a8-c951-49f6-987d-7dd98a46bb98",
            "b51c888f-909a-43ac-a4ab-d9ef97b6f4d3",
            "16c5b9bc-1eac-4d3b-860a-80a6ccf50881",
            "48cf1b08-0cb3-4d92-a1a3-0da6733c6be2",
            "7d78c140-967f-465d-a8ff-0a9c88d3348c",
            "e1d4c1f7-7c1c-4bc8-9f0e-9059d52c3567",
            "4cb2ce3b-1f53-4e5d-8850-94bde3e3b849",
            "7c051a44-0ac5-4d6a-80c4-988a43e4d117",
            "0f787a6f-6e2e-46c8-85a7-e19734cb67b2",
            "5f77b39e-1f59-45da-b8f1-8133fc525a45",
            "a371982d-8d4f-4941-9f66-c34b5ef5f0b7",
            "a89f37fc-1cf7-4bd2-9a4b-7a582e6a7a47",
            "f82cf4d2-409c-4eb7-97c4-8d711a590eb9",
            "e1f1c496-9879-47c2-a29c-58772a85b60d",
            "cfd8b3dd-c85e-4be4-ba8d-7a8cc3523f91",
            "7ef15b50-1a9d-4f4e-aae9-523ea3d1238b",
            "b155173d-c0e1-4091-b04e-9c2e7f590b56",
            "c30af372-520b-4e18-961d-5d1aa9f9d080",
            "903fd0d1-b158-468b-b0e7-1bc5c98d65a1",
            "3f4237ac-9e56-465e-8a9e-29bfa7c98cc0",
            "d88d2d2c-8b10-4a41-ae8b-1d4f042c5112",
            "6ff77341-4e15-4757-aafe-3e7f95b8d3a9",
            "76c1acfc-9f3e-431f-9e8a-9435e04d55ad",
            "e6c8a48f-9843-4d7c-ba2a-1e51b53cd77e",
            "1d0ff5b0-c487-4dd1-99ad-7946310888ee",
            "c469b5d0-5c24-48f1-9742-0c812f7d2fc8",
            "d72c7e10-4f80-47d1-ba65-70f7478a6a1e",
            "b54a9863-1f72-4d3a-8759-0e287c6b2284",
            "8599cd8e-9b4d-4c63-b103-3b639b33a008",
            "82e87516-4855-4f92-8bf1-c189cd34e028",
            "4cf6a319-242b-4ed5-90b5-c0aeb6fc73d5",
            "7af10a3e-bd48-4bda-9f63-2e57c1602bbd",
            "2d8cb272-b91f-460f-8bd4-5cd69b1f5134",
            "5c963548-7e69-4d1b-9fe3-0e13d64a3d94",
            "72e268fe-f87c-4d42-ba84-bc5ee170e4d9",
            "993f234f-c90d-44c0-8ee1-543e59417c49",
            "46c7f43e-e1bf-4db3-8e5a-0fb2a185576a",
            "36f1557b-b4b1-4e21-9a5f-11daed2b6194",
            "0a246fcf-8b71-4917-b154-44232f862e14",
            "3db3b95b-f7cd-4f91-ba34-86751eeea7d1",
            "3a0749a2-0a06-4bfc-b4a3-39e8e4cda3c1",
            "84e5f5e8-ff9d-4a7b-8f20-80333cd1c28f",
            "721a195f-b81c-40b7-889e-8f01d7b86c2c",
            "18af79e0-e3e8-4eac-baa4-7c8903c1bb13"
    };

    public static String[] getRandomUsernamesSlice(final int size) {
        assert size > 0;
        final java.lang.String[] strings = new String[size];

        int lastRand = -1;
        for (int i = 0; i < size; i++) {

            int newRand = RAND.nextInt(0, MINECRAFT_USERNAMES.length);
            int safetyCount = 0;
            while (newRand == lastRand && safetyCount++ < 1E3) {
                newRand = RAND.nextInt(0, MINECRAFT_USERNAMES.length);
            }

            strings[i] = MINECRAFT_USERNAMES[newRand];
        }

        return strings;
    }

    public static String[] getRandomUUIDSlice(int size) {
        assert size > 0;
        final java.lang.String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = HARDCODED_UUIDS[RAND.nextInt(0, HARDCODED_UUIDS.length)];
        }
        return strings;
    }

}
