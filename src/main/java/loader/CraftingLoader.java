package loader;

import EnumList.BlockList;
import EnumList.ToolList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import net.minecraft.item.ItemStack;

import static loader.ItemLoader.upgradeSmithingTemplate;
import static loader.MachineLoader.UpgraderMain;

public class CraftingLoader {
    public CraftingLoader() {
        registerMachineRecipe();
        registerUpgradeSmithingTemplateRecipe();
    }

    private static final long bits = GTModHandler.RecipeBits.NOT_REMOVABLE | GTModHandler.RecipeBits.REVERSIBLE
        | GTModHandler.RecipeBits.BUFFERED;

    private static final long bitsd = GTModHandler.RecipeBits.DISMANTLEABLE | bits;

    private static void registerMachineRecipe() {
        GTModHandler.addCraftingRecipe(
            UpgraderMain,
            bitsd,
            new Object[] {
                "CCC",
                "CMC",
                "CCC",
                'M', BlockList.Machine_Casing_ULV,
                'C', OrePrefixes.circuit.get(Materials.ULV)});
    }

    private static void registerUpgradeSmithingTemplateRecipe() {
        ItemStack[] Central_Synthetic_Item = {
            BlockList.Machine_Casing_LV,
            BlockList.Machine_Casing_MV,
            BlockList.Machine_Casing_HV,
            BlockList.Machine_Casing_EV,
            BlockList.Machine_Casing_IV,
            BlockList.Machine_Casing_Luv,
            BlockList.Machine_Casing_ZPM,
            BlockList.Machine_Casing_UV,
            BlockList.Machine_Casing_UHV,
            BlockList.Machine_Casing_UEV,
            BlockList.Machine_Casing_UIV,
            BlockList.Machine_Casing_UMV,
            BlockList.Machine_Casing_UXV,
            BlockList.Machine_Casing_ULV,
            BlockList.Machine_Hull_ULV,
            BlockList.Machine_Hull_LV,
            BlockList.Machine_Hull_MV,
            BlockList.Machine_Hull_HV,
            BlockList.Machine_Hull_EV,
            BlockList.Machine_Hull_IV,
            BlockList.Machine_Hull_LuV,
            BlockList.Machine_Hull_ZPM,
            BlockList.Machine_Hull_UV,
            BlockList.Machine_Hull_UHV,
            BlockList.Machine_Hull_UEV,
            BlockList.Machine_Hull_UIV,
            BlockList.Machine_Hull_UMV,
            BlockList.Machine_Hull_UXV,
            BlockList.Machine_Hull_MAX
        };

        for (int i = 0; i < Central_Synthetic_Item.length; i++) {
            GTModHandler.addCraftingRecipe(
                new ItemStack(upgradeSmithingTemplate, 1, i),
                bitsd,
                new Object[] {
                    "ABC",
                    "DEF",
                    "GHI",
                    'A', ToolList.Single_Use_File,
                    'B', ToolList.Single_Use_Wrench,
                    'C', ToolList.Single_Use_Crowbar,
                    'D', ToolList.Single_Use_Cutter,
                    'E', Central_Synthetic_Item[i],
                    'F', ToolList.Single_Use_Hammer,
                    'G', ToolList.Single_Use_Mallet,
                    'H', ToolList.Single_Use_Screwdriver,
                    'I', ToolList.Single_Use_Saw});
        }
        /*
        // "UpgradeSmithingTemplate_ULV-LV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 0),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_LV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_LV-MV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 1),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_MV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_MV-HV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 2),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_HV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_HV-EV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 3),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_EV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_EV-IV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 4),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_IV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_IV-LuV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 5),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_Luv,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_LuV-ZPM"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 6),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_ZPM,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_ZPM-UV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 7),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_UV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_UV-UHV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 8),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_UHV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_UHV-UEV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 9),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_UEV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_UEV-UIV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 10),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_UIV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_UIV-UMV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 11),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_UMV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_UMV-UXV"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 12),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_UXV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

        // "UpgradeSmithingTemplate_UXV-MAX"
        GTModHandler.addCraftingRecipe(
            new ItemStack(upgradeSmithingTemplate, 1, 13),
            bitsd,
            new Object[] {
                "ABC",
                "DEF",
                "GHI",
                'A', ToolList.Single_Use_File,
                'B', ToolList.Single_Use_Wrench,
                'C', ToolList.Single_Use_Crowbar,
                'D', ToolList.Single_Use_Cutter,
                'E', BlockList.Machine_Casing_ULV,
                'F', ToolList.Single_Use_Hammer,
                'G', ToolList.Single_Use_Mallet,
                'H', ToolList.Single_Use_Screwdriver,
                'I', ToolList.Single_Use_Saw});

         */
    }
}
