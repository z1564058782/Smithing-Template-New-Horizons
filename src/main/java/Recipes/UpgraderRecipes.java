package Recipes;

import static bartworks.util.BWUtil.setStackSize;

import net.minecraft.item.ItemStack;

import EnumList.*;
import RecipesFrontend.UpgraderFrontend;
import gregtech.api.enums.GTValues;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMapBackend;
import gregtech.api.recipe.RecipeMapBuilder;

public class UpgraderRecipes {

    public static final RecipeMap<RecipeMapBackend> addUpgraderRecipes = RecipeMapBuilder.of("Upgrader")
        .maxIO(2, 1, 0, 0)
        .minInputs(2, 0)
        .neiHandlerInfo(builder -> builder.setHeight(128))
        .frontend(UpgraderFrontend::new)
        .neiTransferRect(85, 42, 20, 16)
        .build();

    public static void addUpgraderRecipes_Voltage() {
        ItemStack[][] ULV_UV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_ULV_LV, ItemList.UpgradeSmithingTemplate_LV_MV,
                ItemList.UpgradeSmithingTemplate_MV_HV, ItemList.UpgradeSmithingTemplate_HV_EV,
                ItemList.UpgradeSmithingTemplate_EV_IV, ItemList.UpgradeSmithingTemplate_IV_LuV,
                ItemList.UpgradeSmithingTemplate_LuV_ZPM, ItemList.UpgradeSmithingTemplate_ZPM_UV },

            // Block Solar Panel
            { BlockList.Block_Solar_Panel_ULV, BlockList.Block_Solar_Panel_LV, BlockList.Block_Solar_Panel_MV,
                BlockList.Block_Solar_Panel_HV, BlockList.Block_Solar_Panel_EV, BlockList.Block_Solar_Panel_IV,
                BlockList.Block_Solar_Panel_LuV, BlockList.Block_Solar_Panel_ZPM, BlockList.Block_Solar_Panel_UV }, };

        for (int i = 1; i < ULV_UV_List.length; i++) {
            for (int j = 0; j < ULV_UV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(ULV_UV_List[i][j], ULV_UV_List[0][j])
                    .itemOutputs(ULV_UV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] ULV_UHV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_ULV_LV, ItemList.UpgradeSmithingTemplate_LV_MV,
                ItemList.UpgradeSmithingTemplate_MV_HV, ItemList.UpgradeSmithingTemplate_HV_EV,
                ItemList.UpgradeSmithingTemplate_EV_IV, ItemList.UpgradeSmithingTemplate_IV_LuV,
                ItemList.UpgradeSmithingTemplate_LuV_ZPM, ItemList.UpgradeSmithingTemplate_ZPM_UV,
                ItemList.UpgradeSmithingTemplate_UV_UHV },

            // Item Distributor
            { BlockList.Item_Distributor_ULV, BlockList.Item_Distributor_LV, BlockList.Item_Distributor_MV,
                BlockList.Item_Distributor_HV, BlockList.Item_Distributor_EV, BlockList.Item_Distributor_IV,
                BlockList.Item_Distributor_LuV, BlockList.Item_Distributor_ZPM, BlockList.Item_Distributor_UV,
                BlockList.Item_Distributor_UHV },

            // Item Filter
            { BlockList.Item_Filter_ULV, BlockList.Item_Filter_LV, BlockList.Item_Filter_MV, BlockList.Item_Filter_HV,
                BlockList.Item_Filter_EV, BlockList.Item_Filter_IV, BlockList.Item_Filter_LuV,
                BlockList.Item_Filter_ZPM, BlockList.Item_Filter_UV, BlockList.Item_Filter_UHV },

            // Input Bus
            { HatchList.Input_Bus_ULV, HatchList.Input_Bus_LV, HatchList.Input_Bus_MV, HatchList.Input_Bus_HV,
                HatchList.Input_Bus_EV, HatchList.Input_Bus_IV, HatchList.Input_Bus_LuV, HatchList.Input_Bus_ZPM,
                HatchList.Input_Bus_UV, HatchList.Input_Bus_UHV },

            // Output Bus
            { HatchList.Output_Bus_ULV, HatchList.Output_Bus_LV, HatchList.Output_Bus_MV, HatchList.Output_Bus_HV,
                HatchList.Output_Bus_EV, HatchList.Output_Bus_IV, HatchList.Output_Bus_LuV, HatchList.Output_Bus_ZPM,
                HatchList.Output_Bus_UV, HatchList.Output_Bus_UHV },

            // Recipe Filter
            { BlockList.Recipe_Filter_ULV, BlockList.Recipe_Filter_LV, BlockList.Recipe_Filter_MV,
                BlockList.Recipe_Filter_HV, BlockList.Recipe_Filter_EV, BlockList.Recipe_Filter_IV,
                BlockList.Recipe_Filter_LuV, BlockList.Recipe_Filter_ZPM, BlockList.Recipe_Filter_UV,
                BlockList.Recipe_Filter_UHV },

            // Regulator Filter
            { BlockList.Regulator_ULV, BlockList.Regulator_LV, BlockList.Regulator_MV, BlockList.Regulator_HV,
                BlockList.Regulator_EV, BlockList.Regulator_IV, BlockList.Regulator_LuV, BlockList.Regulator_ZPM,
                BlockList.Regulator_UV, BlockList.Regulator_UHV },

            // Super Buffer
            { BlockList.Super_Buffer_ULV, BlockList.Super_Buffer_LV, BlockList.Super_Buffer_MV,
                BlockList.Super_Buffer_HV, BlockList.Super_Buffer_EV, BlockList.Super_Buffer_IV,
                BlockList.Super_Buffer_LuV, BlockList.Super_Buffer_ZPM, BlockList.Super_Buffer_UV,
                BlockList.Super_Buffer_UHV },

            // Type Filter
            { BlockList.Type_Filter_ULV, BlockList.Type_Filter_LV, BlockList.Type_Filter_MV, BlockList.Type_Filter_HV,
                BlockList.Type_Filter_EV, BlockList.Type_Filter_IV, BlockList.Type_Filter_LuV,
                BlockList.Type_Filter_ZPM, BlockList.Type_Filter_UV, BlockList.Type_Filter_UHV },

        };

        for (int i = 1; i < ULV_UHV_List.length; i++) {
            for (int j = 0; j < ULV_UHV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(ULV_UHV_List[i][j], ULV_UHV_List[0][j])
                    .itemOutputs(ULV_UHV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] ULV_UIV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_ULV_LV, ItemList.UpgradeSmithingTemplate_LV_MV,
                ItemList.UpgradeSmithingTemplate_MV_HV, ItemList.UpgradeSmithingTemplate_HV_EV,
                ItemList.UpgradeSmithingTemplate_EV_IV, ItemList.UpgradeSmithingTemplate_IV_LuV,
                ItemList.UpgradeSmithingTemplate_LuV_ZPM, ItemList.UpgradeSmithingTemplate_ZPM_UV,
                ItemList.UpgradeSmithingTemplate_UV_UHV, ItemList.UpgradeSmithingTemplate_UHV_UEV,
                ItemList.UpgradeSmithingTemplate_UEV_UIV },

            // Solar Panel
            { ItemList.Solar_Panel_ULV, ItemList.Solar_Panel_LV, ItemList.Solar_Panel_MV, ItemList.Solar_Panel_HV,
                ItemList.Solar_Panel_EV, ItemList.Solar_Panel_IV, ItemList.Solar_Panel_LuV, ItemList.Solar_Panel_ZPM,
                ItemList.Solar_Panel_UV, ItemList.Solar_Panel_UHV, ItemList.Solar_Panel_UEV,
                ItemList.Solar_Panel_UIV }, };

        for (int i = 1; i < ULV_UIV_List.length; i++) {
            for (int j = 0; j < ULV_UIV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(ULV_UIV_List[i][j], ULV_UIV_List[0][j])
                    .itemOutputs(ULV_UIV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] ULV_UXV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_ULV_LV, ItemList.UpgradeSmithingTemplate_LV_MV,
                ItemList.UpgradeSmithingTemplate_MV_HV, ItemList.UpgradeSmithingTemplate_HV_EV,
                ItemList.UpgradeSmithingTemplate_EV_IV, ItemList.UpgradeSmithingTemplate_IV_LuV,
                ItemList.UpgradeSmithingTemplate_LuV_ZPM, ItemList.UpgradeSmithingTemplate_ZPM_UV,
                ItemList.UpgradeSmithingTemplate_UV_UHV, ItemList.UpgradeSmithingTemplate_UHV_UEV,
                ItemList.UpgradeSmithingTemplate_UEV_UIV, ItemList.UpgradeSmithingTemplate_UIV_UMV,
                ItemList.UpgradeSmithingTemplate_UMV_UXV },

            // Battery Charger
            { BlockList.Battery_Charger_ULV, BlockList.Battery_Charger_LV, BlockList.Battery_Charger_MV,
                BlockList.Battery_Charger_HV, BlockList.Battery_Charger_EV, BlockList.Battery_Charger_IV,
                BlockList.Battery_Charger_LuV, BlockList.Battery_Charger_ZPM, BlockList.Battery_Charger_UV,
                BlockList.Battery_Charger_UHV, BlockList.Battery_Charger_UEV, BlockList.Battery_Charger_UIV,
                BlockList.Battery_Charger_UMV, BlockList.Battery_Charger_UXV },

            // Dynamo Hatch
            { HatchList.Dynamo_Hatch_ULV, HatchList.Dynamo_Hatch_LV, HatchList.Dynamo_Hatch_MV,
                HatchList.Dynamo_Hatch_HV, HatchList.Dynamo_Hatch_EV, HatchList.Dynamo_Hatch_IV,
                HatchList.Dynamo_Hatch_LuV, HatchList.Dynamo_Hatch_ZPM, HatchList.Dynamo_Hatch_UV,
                HatchList.Dynamo_Hatch_UHV, HatchList.Dynamo_Hatch_UEV, HatchList.Dynamo_Hatch_UIV,
                HatchList.Dynamo_Hatch_UMV, HatchList.Dynamo_Hatch_UXV },

            // Energy Hatch
            { HatchList.Energy_Hatch_ULV, HatchList.Energy_Hatch_LV, HatchList.Energy_Hatch_MV,
                HatchList.Energy_Hatch_HV, HatchList.Energy_Hatch_EV, HatchList.Energy_Hatch_IV,
                HatchList.Energy_Hatch_LuV, HatchList.Energy_Hatch_ZPM, HatchList.Energy_Hatch_UV,
                HatchList.Energy_Hatch_UHV, HatchList.Energy_Hatch_UEV, HatchList.Energy_Hatch_UIV,
                HatchList.Energy_Hatch_UMV, HatchList.Energy_Hatch_UXV },

            // Hi-Amp Transformer
            { BlockList.Hi_Amp_Transformer_ULV, BlockList.Hi_Amp_Transformer_LV, BlockList.Hi_Amp_Transformer_MV,
                BlockList.Hi_Amp_Transformer_HV, BlockList.Hi_Amp_Transformer_EV, BlockList.Hi_Amp_Transformer_IV,
                BlockList.Hi_Amp_Transformer_LuV, BlockList.Hi_Amp_Transformer_ZPM, BlockList.Hi_Amp_Transformer_UV,
                BlockList.Hi_Amp_Transformer_UHV, BlockList.Hi_Amp_Transformer_UEV, BlockList.Hi_Amp_Transformer_UIV,
                BlockList.Hi_Amp_Transformer_UMV, BlockList.Hi_Amp_Transformer_UXV },

            // Power Transformer
            { BlockList.Power_Transformer_ULV, BlockList.Power_Transformer_LV, BlockList.Power_Transformer_MV,
                BlockList.Power_Transformer_HV, BlockList.Power_Transformer_EV, BlockList.Power_Transformer_IV,
                BlockList.Power_Transformer_LuV, BlockList.Power_Transformer_ZPM, BlockList.Power_Transformer_UV,
                BlockList.Power_Transformer_UHV, BlockList.Power_Transformer_UEV, BlockList.Power_Transformer_UIV,
                BlockList.Power_Transformer_UMV, BlockList.Power_Transformer_UXV },

            // Transformer
            { BlockList.Transformer_ULV, BlockList.Transformer_LV, BlockList.Transformer_MV, BlockList.Transformer_HV,
                BlockList.Transformer_EV, BlockList.Transformer_IV, BlockList.Transformer_LuV,
                BlockList.Transformer_ZPM, BlockList.Transformer_UV, BlockList.Transformer_UHV,
                BlockList.Transformer_UEV, BlockList.Transformer_UIV, BlockList.Transformer_UMV,
                BlockList.Transformer_UXV }, };

        for (int i = 1; i < ULV_UXV_List.length; i++) {
            for (int j = 0; j < ULV_UXV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(ULV_UXV_List[i][j], ULV_UXV_List[0][j])
                    .itemOutputs(ULV_UXV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] ULV_UXV_List_64 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_ULV_LV, ItemList.UpgradeSmithingTemplate_LV_MV,
                ItemList.UpgradeSmithingTemplate_MV_HV, ItemList.UpgradeSmithingTemplate_HV_EV,
                ItemList.UpgradeSmithingTemplate_EV_IV, ItemList.UpgradeSmithingTemplate_IV_LuV,
                ItemList.UpgradeSmithingTemplate_LuV_ZPM, ItemList.UpgradeSmithingTemplate_ZPM_UV,
                ItemList.UpgradeSmithingTemplate_UV_UHV, ItemList.UpgradeSmithingTemplate_UHV_UEV,
                ItemList.UpgradeSmithingTemplate_UEV_UIV, ItemList.UpgradeSmithingTemplate_UIV_UMV,
                ItemList.UpgradeSmithingTemplate_UMV_UXV },

            // 1x Superconductor
            { WireList.Red_Alloy_Cable1, WireList.Redstone_Alloy_Cable1, WireList.Superconductor1_MV,
                WireList.Superconductor1_HV, WireList.Superconductor1_EV, WireList.Superconductor1_IV,
                WireList.Superconductor1_LuV, WireList.Superconductor1_ZPM, WireList.Superconductor1_UV,
                WireList.Superconductor1_UHV, WireList.Superconductor1_UEV, WireList.Superconductor1_UIV,
                WireList.Superconductor1_UMV, WireList.SpaceTime_Wire1 },

            // 2x Superconductor
            { WireList.Red_Alloy_Cable2, WireList.Redstone_Alloy_Cable2, WireList.Superconductor2_MV,
                WireList.Superconductor2_HV, WireList.Superconductor2_EV, WireList.Superconductor2_IV,
                WireList.Superconductor2_LuV, WireList.Superconductor2_ZPM, WireList.Superconductor2_UV,
                WireList.Superconductor2_UHV, WireList.Superconductor2_UEV, WireList.Superconductor2_UIV,
                WireList.Superconductor2_UMV, WireList.SpaceTime_Wire2 },

            // 4x Superconductor
            { WireList.Red_Alloy_Cable4, WireList.Redstone_Alloy_Cable4, WireList.Superconductor4_MV,
                WireList.Superconductor4_HV, WireList.Superconductor4_EV, WireList.Superconductor4_IV,
                WireList.Superconductor4_LuV, WireList.Superconductor4_ZPM, WireList.Superconductor4_UV,
                WireList.Superconductor4_UHV, WireList.Superconductor4_UEV, WireList.Superconductor4_UIV,
                WireList.Superconductor4_UMV, WireList.SpaceTime_Wire4 },

            // 8x Superconductor
            { WireList.Red_Alloy_Cable8, WireList.Redstone_Alloy_Cable8, WireList.Superconductor8_MV,
                WireList.Superconductor8_HV, WireList.Superconductor8_EV, WireList.Superconductor8_IV,
                WireList.Superconductor8_LuV, WireList.Superconductor8_ZPM, WireList.Superconductor8_UV,
                WireList.Superconductor8_UHV, WireList.Superconductor8_UEV, WireList.Superconductor8_UIV,
                WireList.Superconductor8_UMV, WireList.SpaceTime_Wire8 },

            // 12x Superconductor
            { WireList.Red_Alloy_Cable12, WireList.Redstone_Alloy_Cable12, WireList.Superconductor12_MV,
                WireList.Superconductor12_HV, WireList.Superconductor12_EV, WireList.Superconductor12_IV,
                WireList.Superconductor12_LuV, WireList.Superconductor12_ZPM, WireList.Superconductor12_UV,
                WireList.Superconductor12_UHV, WireList.Superconductor12_UEV, WireList.Superconductor12_UIV,
                WireList.Superconductor12_UMV, WireList.SpaceTime_Wire12 },

            // 16x Superconductor
            { WireList.Red_Alloy_Cable16, WireList.Redstone_Alloy_Cable16, WireList.Superconductor16_MV,
                WireList.Superconductor16_HV, WireList.Superconductor16_EV, WireList.Superconductor16_IV,
                WireList.Superconductor16_LuV, WireList.Superconductor16_ZPM, WireList.Superconductor16_UV,
                WireList.Superconductor16_UHV, WireList.Superconductor16_UEV, WireList.Superconductor16_UIV,
                WireList.Superconductor16_UMV, WireList.SpaceTime_Wire16 }, };

        for (int i = 1; i < ULV_UXV_List_64.length; i++) {
            for (int j = 0; j < ULV_UXV_List_64[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(ULV_UXV_List_64[i][j], 64), ULV_UXV_List_64[0][j])
                    .itemOutputs(setStackSize(ULV_UXV_List_64[i][j + 1], 64))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] ULV_MAX_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_ULV_LV, ItemList.UpgradeSmithingTemplate_LV_MV,
                ItemList.UpgradeSmithingTemplate_MV_HV, ItemList.UpgradeSmithingTemplate_HV_EV,
                ItemList.UpgradeSmithingTemplate_EV_IV, ItemList.UpgradeSmithingTemplate_IV_LuV,
                ItemList.UpgradeSmithingTemplate_LuV_ZPM, ItemList.UpgradeSmithingTemplate_ZPM_UV,
                ItemList.UpgradeSmithingTemplate_UV_UHV, ItemList.UpgradeSmithingTemplate_UHV_UEV,
                ItemList.UpgradeSmithingTemplate_UEV_UIV, ItemList.UpgradeSmithingTemplate_UIV_UMV,
                ItemList.UpgradeSmithingTemplate_UMV_UXV, ItemList.UpgradeSmithingTemplate_UXV_MAX },

            // Battery Buffer 1x
            { BlockList.Battery_Buffer1_ULV, BlockList.Battery_Buffer1_LV, BlockList.Battery_Buffer1_MV,
                BlockList.Battery_Buffer1_HV, BlockList.Battery_Buffer1_EV, BlockList.Battery_Buffer1_IV,
                BlockList.Battery_Buffer1_LuV, BlockList.Battery_Buffer1_ZPM, BlockList.Battery_Buffer1_UV,
                BlockList.Battery_Buffer1_UHV, BlockList.Battery_Buffer1_UEV, BlockList.Battery_Buffer1_UIV,
                BlockList.Battery_Buffer1_UMV, BlockList.Battery_Buffer1_UXV, BlockList.Battery_Buffer1_MAX },

            // Battery Buffer 4x
            { BlockList.Battery_Buffer4_ULV, BlockList.Battery_Buffer4_LV, BlockList.Battery_Buffer4_MV,
                BlockList.Battery_Buffer4_HV, BlockList.Battery_Buffer4_EV, BlockList.Battery_Buffer4_IV,
                BlockList.Battery_Buffer4_LuV, BlockList.Battery_Buffer4_ZPM, BlockList.Battery_Buffer4_UV,
                BlockList.Battery_Buffer4_UHV, BlockList.Battery_Buffer4_UEV, BlockList.Battery_Buffer4_UIV,
                BlockList.Battery_Buffer4_UMV, BlockList.Battery_Buffer4_UXV, BlockList.Battery_Buffer4_MAX },

            // Battery Buffer 9x
            { BlockList.Battery_Buffer9_ULV, BlockList.Battery_Buffer9_LV, BlockList.Battery_Buffer9_MV,
                BlockList.Battery_Buffer9_HV, BlockList.Battery_Buffer9_EV, BlockList.Battery_Buffer9_IV,
                BlockList.Battery_Buffer9_LuV, BlockList.Battery_Buffer9_ZPM, BlockList.Battery_Buffer9_UV,
                BlockList.Battery_Buffer9_UHV, BlockList.Battery_Buffer9_UEV, BlockList.Battery_Buffer9_UIV,
                BlockList.Battery_Buffer9_UMV, BlockList.Battery_Buffer9_UXV, BlockList.Battery_Buffer9_MAX },

            // Battery Buffer 16x
            { BlockList.Battery_Buffer16_ULV, BlockList.Battery_Buffer16_LV, BlockList.Battery_Buffer16_MV,
                BlockList.Battery_Buffer16_HV, BlockList.Battery_Buffer16_EV, BlockList.Battery_Buffer16_IV,
                BlockList.Battery_Buffer16_LuV, BlockList.Battery_Buffer16_ZPM, BlockList.Battery_Buffer16_UV,
                BlockList.Battery_Buffer16_UHV, BlockList.Battery_Buffer16_UEV, BlockList.Battery_Buffer16_UIV,
                BlockList.Battery_Buffer16_UMV, BlockList.Battery_Buffer16_UXV, BlockList.Battery_Buffer16_MAX },

            // Cable Diode 2A
            { BlockList.Cable_Diode2_ULV, BlockList.Cable_Diode2_LV, BlockList.Cable_Diode2_MV,
                BlockList.Cable_Diode2_HV, BlockList.Cable_Diode2_EV, BlockList.Cable_Diode2_IV,
                BlockList.Cable_Diode2_LuV, BlockList.Cable_Diode2_ZPM, BlockList.Cable_Diode2_UV,
                BlockList.Cable_Diode2_UHV, BlockList.Cable_Diode2_UEV, BlockList.Cable_Diode2_UIV,
                BlockList.Cable_Diode2_UMV, BlockList.Cable_Diode2_UXV, BlockList.Cable_Diode2_MAX },

            // Cable Diode 4A
            { BlockList.Cable_Diode4_ULV, BlockList.Cable_Diode4_LV, BlockList.Cable_Diode4_MV,
                BlockList.Cable_Diode4_HV, BlockList.Cable_Diode4_EV, BlockList.Cable_Diode4_IV,
                BlockList.Cable_Diode4_LuV, BlockList.Cable_Diode4_ZPM, BlockList.Cable_Diode4_UV,
                BlockList.Cable_Diode4_UHV, BlockList.Cable_Diode4_UEV, BlockList.Cable_Diode4_UIV,
                BlockList.Cable_Diode4_UMV, BlockList.Cable_Diode4_UXV, BlockList.Cable_Diode4_MAX },

            // Cable Diode 8A
            { BlockList.Cable_Diode8_ULV, BlockList.Cable_Diode8_LV, BlockList.Cable_Diode8_MV,
                BlockList.Cable_Diode8_HV, BlockList.Cable_Diode8_EV, BlockList.Cable_Diode8_IV,
                BlockList.Cable_Diode8_LuV, BlockList.Cable_Diode8_ZPM, BlockList.Cable_Diode8_UV,
                BlockList.Cable_Diode8_UHV, BlockList.Cable_Diode8_UEV, BlockList.Cable_Diode8_UIV,
                BlockList.Cable_Diode8_UMV, BlockList.Cable_Diode8_UXV, BlockList.Cable_Diode8_MAX },

            // Cable Diode 12A
            { BlockList.Cable_Diode12_ULV, BlockList.Cable_Diode12_LV, BlockList.Cable_Diode12_MV,
                BlockList.Cable_Diode12_HV, BlockList.Cable_Diode12_EV, BlockList.Cable_Diode12_IV,
                BlockList.Cable_Diode12_LuV, BlockList.Cable_Diode12_ZPM, BlockList.Cable_Diode12_UV,
                BlockList.Cable_Diode12_UHV, BlockList.Cable_Diode12_UEV, BlockList.Cable_Diode12_UIV,
                BlockList.Cable_Diode12_UMV, BlockList.Cable_Diode12_UXV, BlockList.Cable_Diode12_MAX },

            // Cable Diode 16A
            { BlockList.Cable_Diode16_ULV, BlockList.Cable_Diode16_LV, BlockList.Cable_Diode16_MV,
                BlockList.Cable_Diode16_HV, BlockList.Cable_Diode16_EV, BlockList.Cable_Diode16_IV,
                BlockList.Cable_Diode16_LuV, BlockList.Cable_Diode16_ZPM, BlockList.Cable_Diode16_UV,
                BlockList.Cable_Diode16_UHV, BlockList.Cable_Diode16_UEV, BlockList.Cable_Diode16_UIV,
                BlockList.Cable_Diode16_UMV, BlockList.Cable_Diode16_UXV, BlockList.Cable_Diode16_MAX },

            // Energy Distributor
            { BlockList.Energy_Distributor_ULV, BlockList.Energy_Distributor_LV, BlockList.Energy_Distributor_MV,
                BlockList.Energy_Distributor_HV, BlockList.Energy_Distributor_EV, BlockList.Energy_Distributor_IV,
                BlockList.Energy_Distributor_LuV, BlockList.Energy_Distributor_ZPM, BlockList.Energy_Distributor_UV,
                BlockList.Energy_Distributor_UHV, BlockList.Energy_Distributor_UEV, BlockList.Energy_Distributor_UIV,
                BlockList.Energy_Distributor_UMV, BlockList.Energy_Distributor_UXV, BlockList.Energy_Distributor_MAX },

            // Input Hatch
            { HatchList.Input_Hatch_ULV, HatchList.Input_Hatch_LV, HatchList.Input_Hatch_MV, HatchList.Input_Hatch_HV,
                HatchList.Input_Hatch_EV, HatchList.Input_Hatch_IV, HatchList.Input_Hatch_LuV,
                HatchList.Input_Hatch_ZPM, HatchList.Input_Hatch_UV, HatchList.Input_Hatch_UHV,
                HatchList.Input_Hatch_UEV, HatchList.Input_Hatch_UIV, HatchList.Input_Hatch_UMV,
                HatchList.Input_Hatch_UXV, HatchList.Input_Hatch_MAX },

            // Machine Hull
            { BlockList.Machine_Hull_ULV, BlockList.Machine_Hull_LV, BlockList.Machine_Hull_MV,
                BlockList.Machine_Hull_HV, BlockList.Machine_Hull_EV, BlockList.Machine_Hull_IV,
                BlockList.Machine_Hull_LuV, BlockList.Machine_Hull_ZPM, BlockList.Machine_Hull_UV,
                BlockList.Machine_Hull_UHV, BlockList.Machine_Hull_UEV, BlockList.Machine_Hull_UIV,
                BlockList.Machine_Hull_UMV, BlockList.Machine_Hull_UXV, BlockList.Machine_Hull_MAX },

            // Output Hatch
            { HatchList.Output_Hatch_ULV, HatchList.Output_Hatch_LV, HatchList.Output_Hatch_MV,
                HatchList.Output_Hatch_HV, HatchList.Output_Hatch_EV, HatchList.Output_Hatch_IV,
                HatchList.Output_Hatch_LuV, HatchList.Output_Hatch_ZPM, HatchList.Output_Hatch_UV,
                HatchList.Output_Hatch_UHV, HatchList.Output_Hatch_UEV, HatchList.Output_Hatch_UIV,
                HatchList.Output_Hatch_UMV, HatchList.Output_Hatch_UXV, HatchList.Output_Hatch_MAX },

            // Wireless Energy Hatch
            { HatchList.Wireless_Energy_Hatch_ULV, HatchList.Wireless_Energy_Hatch_LV,
                HatchList.Wireless_Energy_Hatch_MV, HatchList.Wireless_Energy_Hatch_HV,
                HatchList.Wireless_Energy_Hatch_EV, HatchList.Wireless_Energy_Hatch_IV,
                HatchList.Wireless_Energy_Hatch_LuV, HatchList.Wireless_Energy_Hatch_ZPM,
                HatchList.Wireless_Energy_Hatch_UV, HatchList.Wireless_Energy_Hatch_UHV,
                HatchList.Wireless_Energy_Hatch_UEV, HatchList.Wireless_Energy_Hatch_UIV,
                HatchList.Wireless_Energy_Hatch_UMV, HatchList.Wireless_Energy_Hatch_UXV,
                HatchList.Wireless_Energy_Hatch_MAX },

            // Wrap of Circuits
            { ItemList.Wrap_of_Circuits_ULV, ItemList.Wrap_of_Circuits_LV, ItemList.Wrap_of_Circuits_MV,
                ItemList.Wrap_of_Circuits_HV, ItemList.Wrap_of_Circuits_EV, ItemList.Wrap_of_Circuits_IV,
                ItemList.Wrap_of_Circuits_LuV, ItemList.Wrap_of_Circuits_ZPM, ItemList.Wrap_of_Circuits_UV,
                ItemList.Wrap_of_Circuits_UHV, ItemList.Wrap_of_Circuits_UEV, ItemList.Wrap_of_Circuits_UIV,
                ItemList.Wrap_of_Circuits_UMV, ItemList.Wrap_of_Circuits_UXV, ItemList.Wrap_of_Circuits_MAX }, };

        for (int i = 1; i < ULV_MAX_List.length; i++) {
            for (int j = 0; j < ULV_MAX_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(ULV_MAX_List[i][j], ULV_MAX_List[0][j])
                    .itemOutputs(ULV_MAX_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] LV_IV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_LV_MV, ItemList.UpgradeSmithingTemplate_MV_HV,
                ItemList.UpgradeSmithingTemplate_HV_EV, ItemList.UpgradeSmithingTemplate_EV_IV },

            // Electric Oven
            { MachineList.Electric_Oven_LV, MachineList.Electric_Oven_MV, MachineList.Electric_Oven_HV,
                MachineList.Electric_Oven_EV, MachineList.Electric_Oven_IV }, };

        for (int i = 1; i < LV_IV_List.length; i++) {
            for (int j = 0; j < LV_IV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(LV_IV_List[i][j], LV_IV_List[0][j])
                    .itemOutputs(LV_IV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] LV_UV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_LV_MV, ItemList.UpgradeSmithingTemplate_MV_HV,
                ItemList.UpgradeSmithingTemplate_HV_EV, ItemList.UpgradeSmithingTemplate_EV_IV,
                ItemList.UpgradeSmithingTemplate_IV_LuV, ItemList.UpgradeSmithingTemplate_LuV_ZPM,
                ItemList.UpgradeSmithingTemplate_ZPM_UV },

            // Monster Repellator
            { MachineList.Monster_Repellator_LV, MachineList.Monster_Repellator_MV, MachineList.Monster_Repellator_HV,
                MachineList.Monster_Repellator_EV, MachineList.Monster_Repellator_IV,
                MachineList.Monster_Repellator_LuV, MachineList.Monster_Repellator_ZPM,
                MachineList.Monster_Repellator_UV },

            // Packager
            { MachineList.Packager_LV, MachineList.Packager_MV, MachineList.Packager_HV, MachineList.Packager_EV,
                MachineList.Packager_IV, MachineList.Packager_LuV, MachineList.Packager_ZPM, MachineList.Packager_UV },

            // Printer
            { MachineList.Printer_LV, MachineList.Printer_MV, MachineList.Printer_HV, MachineList.Printer_EV,
                MachineList.Printer_IV, MachineList.Printer_LuV, MachineList.Printer_ZPM, MachineList.Printer_UV },

            // Simple Washer
            { MachineList.Simple_Washer_LV, MachineList.Simple_Washer_MV, MachineList.Simple_Washer_HV,
                MachineList.Simple_Washer_EV, MachineList.Simple_Washer_IV, MachineList.Simple_Washer_LuV,
                MachineList.Simple_Washer_ZPM, MachineList.Simple_Washer_UV },

            // Unpackager
            { MachineList.Unpackager_LV, MachineList.Unpackager_MV, MachineList.Unpackager_HV,
                MachineList.Unpackager_EV, MachineList.Unpackager_IV, MachineList.Unpackager_LuV,
                MachineList.Unpackager_ZPM, MachineList.Unpackager_UV },

            // World Accelerator
            { MachineList.World_Accelerator_LV, MachineList.World_Accelerator_MV, MachineList.World_Accelerator_HV,
                MachineList.World_Accelerator_EV, MachineList.World_Accelerator_IV, MachineList.World_Accelerator_LuV,
                MachineList.World_Accelerator_ZPM, MachineList.World_Accelerator_UV }, };

        for (int i = 1; i < LV_UV_List.length; i++) {
            for (int j = 0; j < LV_UV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(LV_UV_List[i][j], LV_UV_List[0][j])
                    .itemOutputs(LV_UV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] LV_UHV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_LV_MV, ItemList.UpgradeSmithingTemplate_MV_HV,
                ItemList.UpgradeSmithingTemplate_HV_EV, ItemList.UpgradeSmithingTemplate_EV_IV,
                ItemList.UpgradeSmithingTemplate_IV_LuV, ItemList.UpgradeSmithingTemplate_LuV_ZPM,
                ItemList.UpgradeSmithingTemplate_ZPM_UV, ItemList.UpgradeSmithingTemplate_UV_UHV },

            // Muffler Hatch
            { HatchList.Muffler_Hatch_LV, HatchList.Muffler_Hatch_MV, HatchList.Muffler_Hatch_HV,
                HatchList.Muffler_Hatch_EV, HatchList.Muffler_Hatch_IV, HatchList.Muffler_Hatch_LuV,
                HatchList.Muffler_Hatch_ZPM, HatchList.Muffler_Hatch_UV, HatchList.Muffler_Hatch_UHV },

            // Pollution Scrubber
            { MachineList.Pollution_Scrubber_LV, MachineList.Pollution_Scrubber_MV, MachineList.Pollution_Scrubber_HV,
                MachineList.Pollution_Scrubber_EV, MachineList.Pollution_Scrubber_IV,
                MachineList.Pollution_Scrubber_LuV, MachineList.Pollution_Scrubber_ZPM,
                MachineList.Pollution_Scrubber_UV, MachineList.Pollution_Scrubber_UHV }, };

        for (int i = 1; i < LV_UHV_List.length; i++) {
            for (int j = 0; j < LV_UHV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(LV_UHV_List[i][j], LV_UHV_List[0][j])
                    .itemOutputs(LV_UHV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] LV_UMV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_LV_MV, ItemList.UpgradeSmithingTemplate_MV_HV,
                ItemList.UpgradeSmithingTemplate_HV_EV, ItemList.UpgradeSmithingTemplate_EV_IV,
                ItemList.UpgradeSmithingTemplate_IV_LuV, ItemList.UpgradeSmithingTemplate_LuV_ZPM,
                ItemList.UpgradeSmithingTemplate_ZPM_UV, ItemList.UpgradeSmithingTemplate_UV_UHV,
                ItemList.UpgradeSmithingTemplate_UHV_UEV, ItemList.UpgradeSmithingTemplate_UEV_UIV,
                ItemList.UpgradeSmithingTemplate_UIV_UMV },

            // Muffler Hatch
            { MachineList.Alloy_Smelter_LV, MachineList.Alloy_Smelter_MV, MachineList.Alloy_Smelter_HV,
                MachineList.Alloy_Smelter_EV, MachineList.Alloy_Smelter_IV, MachineList.Alloy_Smelter_LuV,
                MachineList.Alloy_Smelter_ZPM, MachineList.Alloy_Smelter_UV, MachineList.Alloy_Smelter_UHV,
                MachineList.Alloy_Smelter_UEV, MachineList.Alloy_Smelter_UIV, MachineList.Alloy_Smelter_UMV },

            // Arc Furnace
            { MachineList.Arc_Furnace_LV, MachineList.Arc_Furnace_MV, MachineList.Arc_Furnace_HV,
                MachineList.Arc_Furnace_EV, MachineList.Arc_Furnace_IV, MachineList.Arc_Furnace_LuV,
                MachineList.Arc_Furnace_ZPM, MachineList.Arc_Furnace_UV, MachineList.Arc_Furnace_UHV,
                MachineList.Arc_Furnace_UEV, MachineList.Arc_Furnace_UIV, MachineList.Arc_Furnace_UMV },

            // Assembler
            { MachineList.Assembler_LV, MachineList.Assembler_MV, MachineList.Assembler_HV, MachineList.Assembler_EV,
                MachineList.Assembler_IV, MachineList.Assembler_LuV, MachineList.Assembler_ZPM,
                MachineList.Assembler_UV, MachineList.Assembler_UHV, MachineList.Assembler_UEV,
                MachineList.Assembler_UIV, MachineList.Assembler_UMV },

            // Autoclave
            { MachineList.Autoclave_LV, MachineList.Autoclave_MV, MachineList.Autoclave_HV, MachineList.Autoclave_EV,
                MachineList.Autoclave_IV, MachineList.Autoclave_LuV, MachineList.Autoclave_ZPM,
                MachineList.Autoclave_UV, MachineList.Autoclave_UHV, MachineList.Autoclave_UEV,
                MachineList.Autoclave_UIV, MachineList.Autoclave_UMV },

            // Bending
            { MachineList.Bending_LV, MachineList.Bending_MV, MachineList.Bending_HV, MachineList.Bending_EV,
                MachineList.Bending_IV, MachineList.Bending_LuV, MachineList.Bending_ZPM, MachineList.Bending_UV,
                MachineList.Bending_UHV, MachineList.Bending_UEV, MachineList.Bending_UIV, MachineList.Bending_UMV },

            // Brewery
            { MachineList.Brewery_LV, MachineList.Brewery_MV, MachineList.Brewery_HV, MachineList.Brewery_EV,
                MachineList.Brewery_IV, MachineList.Brewery_LuV, MachineList.Brewery_ZPM, MachineList.Brewery_UV,
                MachineList.Brewery_UHV, MachineList.Brewery_UEV, MachineList.Brewery_UIV, MachineList.Brewery_UMV },

            // Canner
            { MachineList.Canner_LV, MachineList.Canner_MV, MachineList.Canner_HV, MachineList.Canner_EV,
                MachineList.Canner_IV, MachineList.Canner_LuV, MachineList.Canner_ZPM, MachineList.Canner_UV,
                MachineList.Canner_UHV, MachineList.Canner_UEV, MachineList.Canner_UIV, MachineList.Canner_UMV },

            // Centrifuge
            { MachineList.Centrifuge_LV, MachineList.Centrifuge_MV, MachineList.Centrifuge_HV,
                MachineList.Centrifuge_EV, MachineList.Centrifuge_IV, MachineList.Centrifuge_LuV,
                MachineList.Centrifuge_ZPM, MachineList.Centrifuge_UV, MachineList.Centrifuge_UHV,
                MachineList.Centrifuge_UEV, MachineList.Centrifuge_UIV, MachineList.Centrifuge_UMV },

            // Chemical Bath
            { MachineList.Chemical_Bath_LV, MachineList.Chemical_Bath_MV, MachineList.Chemical_Bath_HV,
                MachineList.Chemical_Bath_EV, MachineList.Chemical_Bath_IV, MachineList.Chemical_Bath_LuV,
                MachineList.Chemical_Bath_ZPM, MachineList.Chemical_Bath_UV, MachineList.Chemical_Bath_UHV,
                MachineList.Chemical_Bath_UEV, MachineList.Chemical_Bath_UIV, MachineList.Chemical_Bath_UMV },

            // Chemical Reactor
            { MachineList.Chemical_Reactor_LV, MachineList.Chemical_Reactor_MV, MachineList.Chemical_Reactor_HV,
                MachineList.Chemical_Reactor_EV, MachineList.Chemical_Reactor_IV, MachineList.Chemical_Reactor_LuV,
                MachineList.Chemical_Reactor_ZPM, MachineList.Chemical_Reactor_UV, MachineList.Chemical_Reactor_UHV,
                MachineList.Chemical_Reactor_UEV, MachineList.Chemical_Reactor_UIV, MachineList.Chemical_Reactor_UMV },

            // Compressor
            { MachineList.Compressor_LV, MachineList.Compressor_MV, MachineList.Compressor_HV,
                MachineList.Compressor_EV, MachineList.Compressor_IV, MachineList.Compressor_LuV,
                MachineList.Compressor_ZPM, MachineList.Compressor_UV, MachineList.Compressor_UHV,
                MachineList.Compressor_UEV, MachineList.Compressor_UIV, MachineList.Compressor_UMV },

            // Cutting
            { MachineList.Cutting_LV, MachineList.Cutting_MV, MachineList.Cutting_HV, MachineList.Cutting_EV,
                MachineList.Cutting_IV, MachineList.Cutting_LuV, MachineList.Cutting_ZPM, MachineList.Cutting_UV,
                MachineList.Cutting_UHV, MachineList.Cutting_UEV, MachineList.Cutting_UIV, MachineList.Cutting_UMV },

            // Distillery
            { MachineList.Distillery_LV, MachineList.Distillery_MV, MachineList.Distillery_HV,
                MachineList.Distillery_EV, MachineList.Distillery_IV, MachineList.Distillery_LuV,
                MachineList.Distillery_ZPM, MachineList.Distillery_UV, MachineList.Distillery_UHV,
                MachineList.Distillery_UEV, MachineList.Distillery_UIV, MachineList.Distillery_UMV },

            // Electric Furnace
            { MachineList.Electric_Furnace_LV, MachineList.Electric_Furnace_MV, MachineList.Electric_Furnace_HV,
                MachineList.Electric_Furnace_EV, MachineList.Electric_Furnace_IV, MachineList.Electric_Furnace_LuV,
                MachineList.Electric_Furnace_ZPM, MachineList.Electric_Furnace_UV, MachineList.Electric_Furnace_UHV,
                MachineList.Electric_Furnace_UEV, MachineList.Electric_Furnace_UIV, MachineList.Electric_Furnace_UMV },

            // Electrolyzer
            { MachineList.Electrolyzer_LV, MachineList.Electrolyzer_MV, MachineList.Electrolyzer_HV,
                MachineList.Electrolyzer_EV, MachineList.Electrolyzer_IV, MachineList.Electrolyzer_LuV,
                MachineList.Electrolyzer_ZPM, MachineList.Electrolyzer_UV, MachineList.Electrolyzer_UHV,
                MachineList.Electrolyzer_UEV, MachineList.Electrolyzer_UIV, MachineList.Electrolyzer_UMV },

            // Electromagnetic Polarizer
            { MachineList.Electromagnetic_Polarizer_LV, MachineList.Electromagnetic_Polarizer_MV,
                MachineList.Electromagnetic_Polarizer_HV, MachineList.Electromagnetic_Polarizer_EV,
                MachineList.Electromagnetic_Polarizer_IV, MachineList.Electromagnetic_Polarizer_LuV,
                MachineList.Electromagnetic_Polarizer_ZPM, MachineList.Electromagnetic_Polarizer_UV,
                MachineList.Electromagnetic_Polarizer_UHV, MachineList.Electromagnetic_Polarizer_UEV,
                MachineList.Electromagnetic_Polarizer_UIV, MachineList.Electromagnetic_Polarizer_UMV },

            // Electromagnetic Separator
            { MachineList.Electromagnetic_Separator_LV, MachineList.Electromagnetic_Separator_MV,
                MachineList.Electromagnetic_Separator_HV, MachineList.Electromagnetic_Separator_EV,
                MachineList.Electromagnetic_Separator_IV, MachineList.Electromagnetic_Separator_LuV,
                MachineList.Electromagnetic_Separator_ZPM, MachineList.Electromagnetic_Separator_UV,
                MachineList.Electromagnetic_Separator_UHV, MachineList.Electromagnetic_Separator_UEV,
                MachineList.Electromagnetic_Separator_UIV, MachineList.Electromagnetic_Separator_UMV },

            // Extruder
            { MachineList.Extruder_LV, MachineList.Extruder_MV, MachineList.Extruder_HV, MachineList.Extruder_EV,
                MachineList.Extruder_IV, MachineList.Extruder_LuV, MachineList.Extruder_ZPM, MachineList.Extruder_UV,
                MachineList.Extruder_UHV, MachineList.Extruder_UEV, MachineList.Extruder_UIV,
                MachineList.Extruder_UMV },

            // Fermenter
            { MachineList.Fermenter_LV, MachineList.Fermenter_MV, MachineList.Fermenter_HV, MachineList.Fermenter_EV,
                MachineList.Fermenter_IV, MachineList.Fermenter_LuV, MachineList.Fermenter_ZPM,
                MachineList.Fermenter_UV, MachineList.Fermenter_UHV, MachineList.Fermenter_UEV,
                MachineList.Fermenter_UIV, MachineList.Fermenter_UMV },

            // Fluid Extractor
            { MachineList.Fluid_Extractor_LV, MachineList.Fluid_Extractor_MV, MachineList.Fluid_Extractor_HV,
                MachineList.Fluid_Extractor_EV, MachineList.Fluid_Extractor_IV, MachineList.Fluid_Extractor_LuV,
                MachineList.Fluid_Extractor_ZPM, MachineList.Fluid_Extractor_UV, MachineList.Fluid_Extractor_UHV,
                MachineList.Fluid_Extractor_UEV, MachineList.Fluid_Extractor_UIV, MachineList.Fluid_Extractor_UMV },

            // Fluid Heater
            { MachineList.Fluid_Heater_LV, MachineList.Fluid_Heater_MV, MachineList.Fluid_Heater_HV,
                MachineList.Fluid_Heater_EV, MachineList.Fluid_Heater_IV, MachineList.Fluid_Heater_LuV,
                MachineList.Fluid_Heater_ZPM, MachineList.Fluid_Heater_UV, MachineList.Fluid_Heater_UHV,
                MachineList.Fluid_Heater_UEV, MachineList.Fluid_Heater_UIV, MachineList.Fluid_Heater_UMV },

            // Fluid Solidifier
            { MachineList.Fluid_Solidifier_LV, MachineList.Fluid_Solidifier_MV, MachineList.Fluid_Solidifier_HV,
                MachineList.Fluid_Solidifier_EV, MachineList.Fluid_Solidifier_IV, MachineList.Fluid_Solidifier_LuV,
                MachineList.Fluid_Solidifier_ZPM, MachineList.Fluid_Solidifier_UV, MachineList.Fluid_Solidifier_UHV,
                MachineList.Fluid_Solidifier_UEV, MachineList.Fluid_Solidifier_UIV, MachineList.Fluid_Solidifier_UMV },

            // Forge Hammer
            { MachineList.Forge_Hammer_LV, MachineList.Forge_Hammer_MV, MachineList.Forge_Hammer_HV,
                MachineList.Forge_Hammer_EV, MachineList.Forge_Hammer_IV, MachineList.Forge_Hammer_LuV,
                MachineList.Forge_Hammer_ZPM, MachineList.Forge_Hammer_UV, MachineList.Forge_Hammer_UHV,
                MachineList.Forge_Hammer_UEV, MachineList.Forge_Hammer_UIV, MachineList.Forge_Hammer_UMV },

            // Forming Press
            { MachineList.Forming_Press_LV, MachineList.Forming_Press_MV, MachineList.Forming_Press_HV,
                MachineList.Forming_Press_EV, MachineList.Forming_Press_IV, MachineList.Forming_Press_LuV,
                MachineList.Forming_Press_ZPM, MachineList.Forming_Press_UV, MachineList.Forming_Press_UHV,
                MachineList.Forming_Press_UEV, MachineList.Forming_Press_UIV, MachineList.Forming_Press_UMV },

            // Laser Engraver
            { MachineList.Laser_Engraver_LV, MachineList.Laser_Engraver_MV, MachineList.Laser_Engraver_HV,
                MachineList.Laser_Engraver_EV, MachineList.Laser_Engraver_IV, MachineList.Laser_Engraver_LuV,
                MachineList.Laser_Engraver_ZPM, MachineList.Laser_Engraver_UV, MachineList.Laser_Engraver_UHV,
                MachineList.Laser_Engraver_UEV, MachineList.Laser_Engraver_UIV, MachineList.Laser_Engraver_UMV },

            // Lathe
            { MachineList.Lathe_LV, MachineList.Lathe_MV, MachineList.Lathe_HV, MachineList.Lathe_EV,
                MachineList.Lathe_IV, MachineList.Lathe_LuV, MachineList.Lathe_ZPM, MachineList.Lathe_UV,
                MachineList.Lathe_UHV, MachineList.Lathe_UEV, MachineList.Lathe_UIV, MachineList.Lathe_UMV },

            // Macerator
            { MachineList.Macerator_LV, MachineList.Macerator_MV, MachineList.Macerator_HV, MachineList.Macerator_EV,
                MachineList.Macerator_IV, MachineList.Macerator_LuV, MachineList.Macerator_ZPM,
                MachineList.Macerator_UV, MachineList.Macerator_UHV, MachineList.Macerator_UEV,
                MachineList.Macerator_UIV, MachineList.Macerator_UMV },

            // Matter Amplifier
            { MachineList.Matter_Amplifier_LV, MachineList.Matter_Amplifier_MV, MachineList.Matter_Amplifier_HV,
                MachineList.Matter_Amplifier_EV, MachineList.Matter_Amplifier_IV, MachineList.Matter_Amplifier_LuV,
                MachineList.Matter_Amplifier_ZPM, MachineList.Matter_Amplifier_UV, MachineList.Matter_Amplifier_UHV,
                MachineList.Matter_Amplifier_UEV, MachineList.Matter_Amplifier_UIV, MachineList.Matter_Amplifier_UMV },

            // Mass Fabrication
            { MachineList.Mass_Fabrication_LV, MachineList.Mass_Fabrication_MV, MachineList.Mass_Fabrication_HV,
                MachineList.Mass_Fabrication_EV, MachineList.Mass_Fabrication_IV, MachineList.Mass_Fabrication_LuV,
                MachineList.Mass_Fabrication_ZPM, MachineList.Mass_Fabrication_UV, MachineList.Mass_Fabrication_UHV,
                MachineList.Mass_Fabrication_UEV, MachineList.Mass_Fabrication_UIV, MachineList.Mass_Fabrication_UMV },

            // Microwave
            { MachineList.Microwave_LV, MachineList.Microwave_MV, MachineList.Microwave_HV, MachineList.Microwave_EV,
                MachineList.Microwave_IV, MachineList.Microwave_LuV, MachineList.Microwave_ZPM,
                MachineList.Microwave_UV, MachineList.Microwave_UHV, MachineList.Microwave_UEV,
                MachineList.Microwave_UIV, MachineList.Microwave_UMV },

            // Mixer
            { MachineList.Mixer_LV, MachineList.Mixer_MV, MachineList.Mixer_HV, MachineList.Mixer_EV,
                MachineList.Mixer_IV, MachineList.Mixer_LuV, MachineList.Mixer_ZPM, MachineList.Mixer_UV,
                MachineList.Mixer_UHV, MachineList.Mixer_UEV, MachineList.Mixer_UIV, MachineList.Mixer_UMV },

            // Ore Washer
            { MachineList.Ore_Washer_LV, MachineList.Ore_Washer_MV, MachineList.Ore_Washer_HV,
                MachineList.Ore_Washer_EV, MachineList.Ore_Washer_IV, MachineList.Ore_Washer_LuV,
                MachineList.Ore_Washer_ZPM, MachineList.Ore_Washer_UV, MachineList.Ore_Washer_UHV,
                MachineList.Ore_Washer_UEV, MachineList.Ore_Washer_UIV, MachineList.Ore_Washer_UMV },

            // Recycler
            { MachineList.Recycler_LV, MachineList.Recycler_MV, MachineList.Recycler_HV, MachineList.Recycler_EV,
                MachineList.Recycler_IV, MachineList.Recycler_LuV, MachineList.Recycler_ZPM, MachineList.Recycler_UV,
                MachineList.Recycler_UHV, MachineList.Recycler_UEV, MachineList.Recycler_UIV,
                MachineList.Recycler_UMV },

            // Replicator
            { MachineList.Replicator_LV, MachineList.Replicator_MV, MachineList.Replicator_HV,
                MachineList.Replicator_EV, MachineList.Replicator_IV, MachineList.Replicator_LuV,
                MachineList.Replicator_ZPM, MachineList.Replicator_UV, MachineList.Replicator_UHV,
                MachineList.Replicator_UEV, MachineList.Replicator_UIV, MachineList.Replicator_UMV },

            // Rock Breaker
            { MachineList.Rock_Breaker_LV, MachineList.Rock_Breaker_MV, MachineList.Rock_Breaker_HV,
                MachineList.Rock_Breaker_EV, MachineList.Rock_Breaker_IV, MachineList.Rock_Breaker_LuV,
                MachineList.Rock_Breaker_ZPM, MachineList.Rock_Breaker_UV, MachineList.Rock_Breaker_UHV,
                MachineList.Rock_Breaker_UEV, MachineList.Rock_Breaker_UIV, MachineList.Rock_Breaker_UMV },

            // Sifter
            { MachineList.Sifter_LV, MachineList.Sifter_MV, MachineList.Sifter_HV, MachineList.Sifter_EV,
                MachineList.Sifter_IV, MachineList.Sifter_LuV, MachineList.Sifter_ZPM, MachineList.Sifter_UV,
                MachineList.Sifter_UHV, MachineList.Sifter_UEV, MachineList.Sifter_UIV, MachineList.Sifter_UMV },

            // Thermal Centrifuge
            { MachineList.Thermal_Centrifuge_LV, MachineList.Thermal_Centrifuge_MV, MachineList.Thermal_Centrifuge_HV,
                MachineList.Thermal_Centrifuge_EV, MachineList.Thermal_Centrifuge_IV,
                MachineList.Thermal_Centrifuge_LuV, MachineList.Thermal_Centrifuge_ZPM,
                MachineList.Thermal_Centrifuge_UV, MachineList.Thermal_Centrifuge_UHV,
                MachineList.Thermal_Centrifuge_UEV, MachineList.Thermal_Centrifuge_UIV,
                MachineList.Thermal_Centrifuge_UMV },

            // Wiremill
            { MachineList.Wiremill_LV, MachineList.Wiremill_MV, MachineList.Wiremill_HV, MachineList.Wiremill_EV,
                MachineList.Wiremill_IV, MachineList.Wiremill_LuV, MachineList.Wiremill_ZPM, MachineList.Wiremill_UV,
                MachineList.Wiremill_UHV, MachineList.Wiremill_UEV, MachineList.Wiremill_UIV,
                MachineList.Wiremill_UMV }, };

        for (int i = 1; i < LV_UMV_List.length; i++) {
            for (int j = 0; j < LV_UMV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(LV_UMV_List[i][j], LV_UMV_List[0][j])
                    .itemOutputs(LV_UMV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] LV_UXV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_LV_MV, ItemList.UpgradeSmithingTemplate_MV_HV,
                ItemList.UpgradeSmithingTemplate_HV_EV, ItemList.UpgradeSmithingTemplate_EV_IV,
                ItemList.UpgradeSmithingTemplate_IV_LuV, ItemList.UpgradeSmithingTemplate_LuV_ZPM,
                ItemList.UpgradeSmithingTemplate_ZPM_UV, ItemList.UpgradeSmithingTemplate_UV_UHV,
                ItemList.UpgradeSmithingTemplate_UHV_UEV, ItemList.UpgradeSmithingTemplate_UEV_UIV,
                ItemList.UpgradeSmithingTemplate_UIV_UMV, ItemList.UpgradeSmithingTemplate_UMV_UXV },

            // Scanner
            { MachineList.Scanner_LV, MachineList.Scanner_MV, MachineList.Scanner_HV, MachineList.Scanner_EV,
                MachineList.Scanner_IV, MachineList.Scanner_LuV, MachineList.Scanner_ZPM, MachineList.Scanner_UV,
                MachineList.Scanner_UHV, MachineList.Scanner_UEV, MachineList.Scanner_UIV, MachineList.Scanner_UMV,
                MachineList.Scanner_UXV }, };

        for (int i = 1; i < LV_UXV_List.length; i++) {
            for (int j = 0; j < LV_UXV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(LV_UXV_List[i][j], LV_UXV_List[0][j])
                    .itemOutputs(LV_UXV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] LV_MAX_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_LV_MV, ItemList.UpgradeSmithingTemplate_MV_HV,
                ItemList.UpgradeSmithingTemplate_HV_EV, ItemList.UpgradeSmithingTemplate_EV_IV,
                ItemList.UpgradeSmithingTemplate_IV_LuV, ItemList.UpgradeSmithingTemplate_LuV_ZPM,
                ItemList.UpgradeSmithingTemplate_ZPM_UV, ItemList.UpgradeSmithingTemplate_UV_UHV,
                ItemList.UpgradeSmithingTemplate_UHV_UEV, ItemList.UpgradeSmithingTemplate_UEV_UIV,
                ItemList.UpgradeSmithingTemplate_UIV_UMV, ItemList.UpgradeSmithingTemplate_UMV_UXV,
                ItemList.UpgradeSmithingTemplate_UXV_MAX },

            // Conveyor Module
            { MachineList.Circuit_Assembler_LV, MachineList.Circuit_Assembler_MV, MachineList.Circuit_Assembler_HV,
                MachineList.Circuit_Assembler_EV, MachineList.Circuit_Assembler_IV, MachineList.Circuit_Assembler_LuV,
                MachineList.Circuit_Assembler_ZPM, MachineList.Circuit_Assembler_UV, MachineList.Circuit_Assembler_UHV,
                MachineList.Circuit_Assembler_UEV, MachineList.Circuit_Assembler_UIV, MachineList.Circuit_Assembler_UMV,
                MachineList.Circuit_Assembler_UXV, MachineList.Circuit_Assembler_MAX },

            // Conveyor Module
            { ItemList.Conveyor_Module_LV, ItemList.Conveyor_Module_MV, ItemList.Conveyor_Module_HV,
                ItemList.Conveyor_Module_EV, ItemList.Conveyor_Module_IV, ItemList.Conveyor_Module_LuV,
                ItemList.Conveyor_Module_ZPM, ItemList.Conveyor_Module_UV, ItemList.Conveyor_Module_UHV,
                ItemList.Conveyor_Module_UEV, ItemList.Conveyor_Module_UIV, ItemList.Conveyor_Module_UMV,
                ItemList.Conveyor_Module_UXV, ItemList.Conveyor_Module_MAX },

            // Electric Motor
            { ItemList.Electric_Motor_LV, ItemList.Electric_Motor_MV, ItemList.Electric_Motor_HV,
                ItemList.Electric_Motor_EV, ItemList.Electric_Motor_IV, ItemList.Electric_Motor_LuV,
                ItemList.Electric_Motor_ZPM, ItemList.Electric_Motor_UV, ItemList.Electric_Motor_UHV,
                ItemList.Electric_Motor_UEV, ItemList.Electric_Motor_UIV, ItemList.Electric_Motor_UMV,
                ItemList.Electric_Motor_UXV, ItemList.Electric_Motor_MAX },

            // Electric Piston
            { ItemList.Electric_Piston_LV, ItemList.Electric_Piston_MV, ItemList.Electric_Piston_HV,
                ItemList.Electric_Piston_EV, ItemList.Electric_Piston_IV, ItemList.Electric_Piston_LuV,
                ItemList.Electric_Piston_ZPM, ItemList.Electric_Piston_UV, ItemList.Electric_Piston_UHV,
                ItemList.Electric_Piston_UEV, ItemList.Electric_Piston_UIV, ItemList.Electric_Piston_UMV,
                ItemList.Electric_Piston_UXV, ItemList.Electric_Piston_MAX },

            // Electric Pump
            { ItemList.Electric_Pump_LV, ItemList.Electric_Pump_MV, ItemList.Electric_Pump_HV,
                ItemList.Electric_Pump_EV, ItemList.Electric_Pump_IV, ItemList.Electric_Pump_LuV,
                ItemList.Electric_Pump_ZPM, ItemList.Electric_Pump_UV, ItemList.Electric_Pump_UHV,
                ItemList.Electric_Pump_UEV, ItemList.Electric_Pump_UIV, ItemList.Electric_Pump_UMV,
                ItemList.Electric_Pump_UXV, ItemList.Electric_Pump_MAX },

            // Emitter
            { ItemList.Emitter_LV, ItemList.Emitter_MV, ItemList.Emitter_HV, ItemList.Emitter_EV, ItemList.Emitter_IV,
                ItemList.Emitter_LuV, ItemList.Emitter_ZPM, ItemList.Emitter_UV, ItemList.Emitter_UHV,
                ItemList.Emitter_UEV, ItemList.Emitter_UIV, ItemList.Emitter_UMV, ItemList.Emitter_UXV,
                ItemList.Emitter_MAX },

            // Field Generator
            { ItemList.Field_Generator_LV, ItemList.Field_Generator_MV, ItemList.Field_Generator_HV,
                ItemList.Field_Generator_EV, ItemList.Field_Generator_IV, ItemList.Field_Generator_LuV,
                ItemList.Field_Generator_ZPM, ItemList.Field_Generator_UV, ItemList.Field_Generator_UHV,
                ItemList.Field_Generator_UEV, ItemList.Field_Generator_UIV, ItemList.Field_Generator_UMV,
                ItemList.Field_Generator_UXV, ItemList.Field_Generator_MAX },

            // Fluid Regulator
            { ItemList.Fluid_Regulator_LV, ItemList.Fluid_Regulator_MV, ItemList.Fluid_Regulator_HV,
                ItemList.Fluid_Regulator_EV, ItemList.Fluid_Regulator_IV, ItemList.Fluid_Regulator_LuV,
                ItemList.Fluid_Regulator_ZPM, ItemList.Fluid_Regulator_UV, ItemList.Fluid_Regulator_UHV,
                ItemList.Fluid_Regulator_UEV, ItemList.Fluid_Regulator_UIV, ItemList.Fluid_Regulator_UMV,
                ItemList.Fluid_Regulator_UXV, ItemList.Fluid_Regulator_MAX },

            // Robot Arm
            { ItemList.Robot_Arm_LV, ItemList.Robot_Arm_MV, ItemList.Robot_Arm_HV, ItemList.Robot_Arm_EV,
                ItemList.Robot_Arm_IV, ItemList.Robot_Arm_LuV, ItemList.Robot_Arm_ZPM, ItemList.Robot_Arm_UV,
                ItemList.Robot_Arm_UHV, ItemList.Robot_Arm_UEV, ItemList.Robot_Arm_UIV, ItemList.Robot_Arm_UMV,
                ItemList.Robot_Arm_UXV, ItemList.Robot_Arm_MAX },

            // Sensor
            { ItemList.Sensor_LV, ItemList.Sensor_MV, ItemList.Sensor_HV, ItemList.Sensor_EV, ItemList.Sensor_IV,
                ItemList.Sensor_LuV, ItemList.Sensor_ZPM, ItemList.Sensor_UV, ItemList.Sensor_UHV, ItemList.Sensor_UEV,
                ItemList.Sensor_UIV, ItemList.Sensor_UMV, ItemList.Sensor_UXV, ItemList.Sensor_MAX },

            // Wireless Energy Cover
            { ItemList.Wireless_Energy_Cover_LV, ItemList.Wireless_Energy_Cover_MV, ItemList.Wireless_Energy_Cover_HV,
                ItemList.Wireless_Energy_Cover_EV, ItemList.Wireless_Energy_Cover_IV,
                ItemList.Wireless_Energy_Cover_LuV, ItemList.Wireless_Energy_Cover_ZPM,
                ItemList.Wireless_Energy_Cover_UV, ItemList.Wireless_Energy_Cover_UHV,
                ItemList.Wireless_Energy_Cover_UEV, ItemList.Wireless_Energy_Cover_UIV,
                ItemList.Wireless_Energy_Cover_UMV, ItemList.Wireless_Energy_Cover_UXV,
                ItemList.Wireless_Energy_Cover_MAX }, };

        for (int i = 1; i < LV_MAX_List.length; i++) {
            for (int j = 0; j < LV_MAX_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(LV_MAX_List[i][j], LV_MAX_List[0][j])
                    .itemOutputs(LV_MAX_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] MV_ZPM_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_MV_HV, ItemList.UpgradeSmithingTemplate_HV_EV,
                ItemList.UpgradeSmithingTemplate_EV_IV, ItemList.UpgradeSmithingTemplate_IV_LuV,
                ItemList.UpgradeSmithingTemplate_LuV_ZPM },

            // Dehydrator
            { MachineList.Dehydrator_MV, MachineList.Dehydrator_HV, MachineList.Dehydrator_EV,
                MachineList.Dehydrator_IV, MachineList.Dehydrator_LuV, MachineList.Dehydrator_ZPM }, };

        for (int i = 1; i < MV_ZPM_List.length; i++) {
            for (int j = 0; j < MV_ZPM_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(MV_ZPM_List[i][j], MV_ZPM_List[0][j])
                    .itemOutputs(MV_ZPM_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] HV_UHV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_HV_EV, ItemList.UpgradeSmithingTemplate_EV_IV,
                ItemList.UpgradeSmithingTemplate_IV_LuV, ItemList.UpgradeSmithingTemplate_LuV_ZPM,
                ItemList.UpgradeSmithingTemplate_ZPM_UV, ItemList.UpgradeSmithingTemplate_UV_UHV },

            // Microwave Energy Transmitter
            { MachineList.Microwave_Energy_Transmitter_HV, MachineList.Microwave_Energy_Transmitter_EV,
                MachineList.Microwave_Energy_Transmitter_IV, MachineList.Microwave_Energy_Transmitter_LuV,
                MachineList.Microwave_Energy_Transmitter_ZPM, MachineList.Microwave_Energy_Transmitter_UV,
                MachineList.Microwave_Energy_Transmitter_UHV }, };

        for (int i = 1; i < HV_UHV_List.length; i++) {
            for (int j = 0; j < HV_UHV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(HV_UHV_List[i][j], HV_UHV_List[0][j])
                    .itemOutputs(HV_UHV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] HV_UMV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_HV_EV, ItemList.UpgradeSmithingTemplate_EV_IV,
                ItemList.UpgradeSmithingTemplate_IV_LuV, ItemList.UpgradeSmithingTemplate_LuV_ZPM,
                ItemList.UpgradeSmithingTemplate_ZPM_UV, ItemList.UpgradeSmithingTemplate_UV_UHV,
                ItemList.UpgradeSmithingTemplate_UHV_UEV, ItemList.UpgradeSmithingTemplate_UEV_UIV,
                ItemList.UpgradeSmithingTemplate_UIV_UMV },

            // BioLab
            { MachineList.BioLab_HV, MachineList.BioLab_EV, MachineList.BioLab_IV, MachineList.BioLab_LuV,
                MachineList.BioLab_ZPM, MachineList.BioLab_UV, MachineList.BioLab_UHV, MachineList.BioLab_UEV,
                MachineList.BioLab_UIV, MachineList.BioLab_UMV }, };

        for (int i = 1; i < HV_UMV_List.length; i++) {
            for (int j = 0; j < HV_UMV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(HV_UMV_List[i][j], HV_UMV_List[0][j])
                    .itemOutputs(HV_UMV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] EV_UXV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_EV_IV, ItemList.UpgradeSmithingTemplate_IV_LuV,
                ItemList.UpgradeSmithingTemplate_LuV_ZPM, ItemList.UpgradeSmithingTemplate_ZPM_UV,
                ItemList.UpgradeSmithingTemplate_UV_UHV, ItemList.UpgradeSmithingTemplate_UHV_UEV,
                ItemList.UpgradeSmithingTemplate_UEV_UIV, ItemList.UpgradeSmithingTemplate_UIV_UMV,
                ItemList.UpgradeSmithingTemplate_UMV_UXV },

            // Quadruple Input Hatch
            { HatchList.Quadruple_Input_Hatch_EV, HatchList.Quadruple_Input_Hatch_IV,
                HatchList.Quadruple_Input_Hatch_LuV, HatchList.Quadruple_Input_Hatch_ZPM,
                HatchList.Quadruple_Input_Hatch_UV, HatchList.Quadruple_Input_Hatch_UHV,
                HatchList.Quadruple_Input_Hatch_UEV, HatchList.Quadruple_Input_Hatch_UIV,
                HatchList.Quadruple_Input_Hatch_UMV, HatchList.Quadruple_Input_Hatch_UXV }, };

        for (int i = 1; i < EV_UXV_List.length; i++) {
            for (int j = 0; j < EV_UXV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(EV_UXV_List[i][j], EV_UXV_List[0][j])
                    .itemOutputs(EV_UXV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] IV_UXV_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_IV_LuV, ItemList.UpgradeSmithingTemplate_LuV_ZPM,
                ItemList.UpgradeSmithingTemplate_ZPM_UV, ItemList.UpgradeSmithingTemplate_UV_UHV,
                ItemList.UpgradeSmithingTemplate_UHV_UEV, ItemList.UpgradeSmithingTemplate_UEV_UIV,
                ItemList.UpgradeSmithingTemplate_UIV_UMV, ItemList.UpgradeSmithingTemplate_UMV_UXV },

            // Buck Converter
            { BlockList.Buck_Converter_IV, BlockList.Buck_Converter_LuV, BlockList.Buck_Converter_ZPM,
                BlockList.Buck_Converter_UV, BlockList.Buck_Converter_UHV, BlockList.Buck_Converter_UEV,
                BlockList.Buck_Converter_UIV, BlockList.Buck_Converter_UMV, BlockList.Buck_Converter_UXV }, };

        for (int i = 1; i < IV_UXV_List.length; i++) {
            for (int j = 0; j < IV_UXV_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(IV_UXV_List[i][j], IV_UXV_List[0][j])
                    .itemOutputs(IV_UXV_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }
    }

    public static void addUpgraderRecipes_Tier() {
        ItemStack[][] Tier_1_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1 },

            // Laser Source Hatch IV
            { HatchList.Dynamo_Hatch64_IV, HatchList.Laser_Source_Hatch256_IV },

            // Laser Target Hatch IV
            { HatchList.Energy_Hatch16_IV, HatchList.Laser_Target_Hatch256_IV }, };

        for (int i = 1; i < Tier_1_List.length; i++) {
            for (int j = 0; j < Tier_1_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_1_List[i][j], Tier_1_List[0][j])
                    .itemOutputs(Tier_1_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_1_List_64 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1 },

            // Solar Panel ULV
            { BlockList.Block_Solar_Panel_ULV, ItemList.Solar_Panel_ULV },

            // Solar Panel LV
            { BlockList.Block_Solar_Panel_LV, ItemList.Solar_Panel_LV },

            // Solar Panel MV
            { BlockList.Block_Solar_Panel_MV, ItemList.Solar_Panel_MV },

            // Solar Panel HV
            { BlockList.Block_Solar_Panel_HV, ItemList.Solar_Panel_HV },

            // Solar Panel EV
            { BlockList.Block_Solar_Panel_EV, ItemList.Solar_Panel_EV },

            // Solar Panel IV
            { BlockList.Block_Solar_Panel_IV, ItemList.Solar_Panel_IV },

            // Solar Panel LuV
            { BlockList.Block_Solar_Panel_LuV, ItemList.Solar_Panel_LuV },

            // Solar Panel ZPM
            { BlockList.Block_Solar_Panel_ZPM, ItemList.Solar_Panel_ZPM },

            // Solar Panel UV
            { BlockList.Block_Solar_Panel_UV, ItemList.Solar_Panel_UV } };

        for (int i = 1; i < Tier_1_List_64.length; i++) {
            for (int j = 0; j < Tier_1_List_64[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_1_List_64[i][j], 64), Tier_1_List_64[0][j])
                    .itemOutputs(setStackSize(Tier_1_List_64[i][j + 1], 64))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_1_Circuit_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1 },

            // Circuit MAX
            { ItemList.Wrap_of_Circuits_ULV, ItemList.Temporally_Transcendent_Mainframe } };

        for (int i = 1; i < Tier_1_Circuit_List.length; i++) {
            for (int j = 0; j < Tier_1_Circuit_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_1_Circuit_List[i][0], 64), Tier_1_Circuit_List[0][j])
                    .itemOutputs(setStackSize(Tier_1_Circuit_List[i][j + 1], 1024))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_2_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2 },

            // Laser Source Hatch LuV
            { HatchList.Dynamo_Hatch64_LuV, HatchList.Laser_Source_Hatch256_LuV, HatchList.Laser_Source_Hatch1024_LuV },

            // Laser Target Hatch LuV
            { HatchList.Energy_Hatch16_LuV, HatchList.Laser_Target_Hatch256_LuV,
                HatchList.Laser_Target_Hatch1024_LuV }, };

        for (int i = 1; i < Tier_2_List.length; i++) {
            for (int j = 0; j < Tier_2_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_2_List[i][j], Tier_2_List[0][j])
                    .itemOutputs(Tier_2_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_2_List_16 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2 },

            // Transformer ULV
            { BlockList.Transformer_ULV, BlockList.Hi_Amp_Transformer_ULV, BlockList.Power_Transformer_ULV },

            // Transformer LV
            { BlockList.Transformer_LV, BlockList.Hi_Amp_Transformer_LV, BlockList.Power_Transformer_LV },

            // Transformer MV
            { BlockList.Transformer_MV, BlockList.Hi_Amp_Transformer_MV, BlockList.Power_Transformer_MV },

            // Transformer HV
            { BlockList.Transformer_HV, BlockList.Hi_Amp_Transformer_HV, BlockList.Power_Transformer_HV },

            // Transformer EV
            { BlockList.Transformer_EV, BlockList.Hi_Amp_Transformer_EV, BlockList.Power_Transformer_EV }, };

        for (int i = 1; i < Tier_2_List_16.length; i++) {
            for (int j = 0; j < Tier_2_List_16[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_2_List_16[i][j], 16), Tier_2_List_16[0][j])
                    .itemOutputs(setStackSize(Tier_2_List_16[i][j + 1], 16))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_2_Circuit_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2 },

            // Circuit ULV
            { ItemList.Wrap_of_Circuits_ULV, ItemList.Vacuum_Tube, ItemList.NAND_Chip },

            // Circuit UXV
            { ItemList.Wrap_of_Circuits_UXV, ItemList.Cosmic_Mainframe,
                ItemList.Temporally_Transcendent_Supercomputer } };

        for (int i = 1; i < Tier_2_Circuit_List.length; i++) {
            for (int j = 0; j < Tier_2_Circuit_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_2_Circuit_List[i][0], 64), Tier_2_Circuit_List[0][j])
                    .itemOutputs(setStackSize(Tier_2_Circuit_List[i][j + 1], 1024))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_3_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3 },

            // Dynamo Hatch EV
            { HatchList.Dynamo_Hatch_EV, HatchList.Dynamo_Hatch4_EV, HatchList.Dynamo_Hatch16_EV,
                HatchList.Dynamo_Hatch64_EV, },

            // Dynamo Hatch IV
            { HatchList.Dynamo_Hatch_IV, HatchList.Dynamo_Hatch4_IV, HatchList.Dynamo_Hatch16_IV,
                HatchList.Dynamo_Hatch64_IV, },

            // Dynamo Hatch LuV
            { HatchList.Dynamo_Hatch_LuV, HatchList.Dynamo_Hatch4_LuV, HatchList.Dynamo_Hatch16_LuV,
                HatchList.Dynamo_Hatch64_LuV, },

            // Dynamo Hatch ZPM
            { HatchList.Dynamo_Hatch_ZPM, HatchList.Dynamo_Hatch4_ZPM, HatchList.Dynamo_Hatch16_ZPM,
                HatchList.Dynamo_Hatch64_ZPM, },

            // Energy Hatch EV
            { HatchList.Energy_Hatch_EV, HatchList.Energy_Hatch4_EV, HatchList.Energy_Hatch16_EV,
                HatchList.Energy_Hatch64_EV, },

            // Energy Hatch IV
            { HatchList.Energy_Hatch_IV, HatchList.Energy_Hatch4_IV, HatchList.Energy_Hatch16_IV,
                HatchList.Energy_Hatch64_IV, },

            // Energy Hatch LuV
            { HatchList.Energy_Hatch_LuV, HatchList.Energy_Hatch4_LuV, HatchList.Energy_Hatch16_LuV,
                HatchList.Energy_Hatch64_LuV, },

            // Energy Hatch ZPM
            { HatchList.Energy_Hatch_ZPM, HatchList.Energy_Hatch4_ZPM, HatchList.Energy_Hatch16_ZPM,
                HatchList.Energy_Hatch64_ZPM, },

            // Energy Hatch UV
            { HatchList.Energy_Hatch_UV, HatchList.Energy_Hatch4_UV, HatchList.Energy_Hatch16_UV,
                HatchList.Energy_Hatch64_UV, },

            // Energy Hatch UHV
            { HatchList.Energy_Hatch_UHV, HatchList.Energy_Hatch4_UHV, HatchList.Energy_Hatch16_UHV,
                HatchList.Energy_Hatch64_UHV, },

            // Energy Hatch UEV
            { HatchList.Energy_Hatch_UEV, HatchList.Energy_Hatch4_UEV, HatchList.Energy_Hatch16_UEV,
                HatchList.Energy_Hatch64_UEV, },

            // Energy Hatch UIV
            { HatchList.Energy_Hatch_UIV, HatchList.Energy_Hatch4_UIV, HatchList.Energy_Hatch16_UIV,
                HatchList.Energy_Hatch64_UIV, },

            // Energy Hatch UMV
            { HatchList.Energy_Hatch_UMV, HatchList.Energy_Hatch4_UMV, HatchList.Energy_Hatch16_UMV,
                HatchList.Energy_Hatch64_UMV, },

            // Energy Hatch UXV
            { HatchList.Energy_Hatch_UXV, HatchList.Energy_Hatch4_UXV, HatchList.Energy_Hatch16_UXV,
                HatchList.Energy_Hatch64_UXV, },

            // Laser Source Hatch ZPM
            { HatchList.Dynamo_Hatch64_ZPM, HatchList.Laser_Source_Hatch256_ZPM, HatchList.Laser_Source_Hatch1024_ZPM,
                HatchList.Laser_Source_Hatch4096_ZPM },

            // Laser Target Hatch ZPM
            { HatchList.Energy_Hatch16_ZPM, HatchList.Laser_Target_Hatch256_ZPM, HatchList.Laser_Target_Hatch1024_ZPM,
                HatchList.Laser_Target_Hatch4096_ZPM },

            // Wireless Energy Hatch MAX
            { HatchList.Wireless_Energy_Hatch_MAX, HatchList.Wireless_Energy_Hatch4_MAX,
                HatchList.Wireless_Energy_Hatch16_MAX, HatchList.Wireless_Energy_Hatch64_MAX, }, };

        for (int i = 1; i < Tier_3_List.length; i++) {
            for (int j = 0; j < Tier_3_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_3_List[i][j], Tier_3_List[0][j])
                    .itemOutputs(Tier_3_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_3_List_16 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3 },

            // Battery Buffer MAX
            { BlockList.Battery_Buffer1_MAX, BlockList.Battery_Buffer4_MAX, BlockList.Battery_Buffer9_MAX,
                BlockList.Battery_Buffer16_MAX },

            // Transformer IV
            { BlockList.Transformer_IV, BlockList.Hi_Amp_Transformer_IV, BlockList.Power_Transformer_IV,
                BlockList.Buck_Converter_IV },

            // Transformer LuV
            { BlockList.Transformer_LuV, BlockList.Hi_Amp_Transformer_LuV, BlockList.Power_Transformer_LuV,
                BlockList.Buck_Converter_LuV },

            // Transformer ZPM
            { BlockList.Transformer_ZPM, BlockList.Hi_Amp_Transformer_ZPM, BlockList.Power_Transformer_ZPM,
                BlockList.Buck_Converter_ZPM },

            // Transformer UV
            { BlockList.Transformer_UV, BlockList.Hi_Amp_Transformer_UV, BlockList.Power_Transformer_UV,
                BlockList.Buck_Converter_UV },

            // Transformer UHV
            { BlockList.Transformer_UHV, BlockList.Hi_Amp_Transformer_UHV, BlockList.Power_Transformer_UHV,
                BlockList.Buck_Converter_UHV },

            // Transformer UEV
            { BlockList.Transformer_UEV, BlockList.Hi_Amp_Transformer_UEV, BlockList.Power_Transformer_UEV,
                BlockList.Buck_Converter_UEV },

            // Transformer UIV
            { BlockList.Transformer_UIV, BlockList.Hi_Amp_Transformer_UIV, BlockList.Power_Transformer_UIV,
                BlockList.Buck_Converter_UIV },

            // Transformer UMV
            { BlockList.Transformer_UMV, BlockList.Hi_Amp_Transformer_UMV, BlockList.Power_Transformer_UMV,
                BlockList.Buck_Converter_UMV },

            // Transformer UXV
            { BlockList.Transformer_UXV, BlockList.Hi_Amp_Transformer_UXV, BlockList.Power_Transformer_UXV,
                BlockList.Buck_Converter_UXV }, };

        for (int i = 1; i < Tier_3_List_16.length; i++) {
            for (int j = 0; j < Tier_3_List_16[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_3_List_16[i][j], 16), Tier_3_List_16[0][j])
                    .itemOutputs(setStackSize(Tier_3_List_16[i][j + 1], 16))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_3_Circuit_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3 },

            // Circuit LV
            { ItemList.Wrap_of_Circuits_LV, ItemList.Integrated_Logic_Circuit, ItemList.Basic_Electronic_Circuit,
                ItemList.Microprocessor },

            // Circuit MV
            { ItemList.Wrap_of_Circuits_MV, ItemList.Good_Electronic_Circuit, ItemList.Good_Integrated_Circuit,
                ItemList.Integrated_Processor },

            // Circuit HV
            { ItemList.Wrap_of_Circuits_HV, ItemList.Processor_Assembly, ItemList.Advanced_Integrated_Circuit,
                ItemList.Nano_Processor },

            // Circuit EV
            { ItemList.Wrap_of_Circuits_EV, ItemList.Workstation, ItemList.Nano_Assembly, ItemList.Quantum_Processor },

            // Circuit UMV
            { ItemList.Wrap_of_Circuits_UMV, ItemList.Exotic_Mainframe, ItemList.Cosmic_Supercomputer,
                ItemList.Temporally_Transcendent_Assembly } };

        for (int i = 1; i < Tier_3_Circuit_List.length; i++) {
            for (int j = 0; j < Tier_3_Circuit_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_3_Circuit_List[i][0], 64), Tier_3_Circuit_List[0][j])
                    .itemOutputs(setStackSize(Tier_3_Circuit_List[i][j + 1], 1024))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_4_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4 },

            // Dynamo Hatch UV
            { HatchList.Dynamo_Hatch_UV, HatchList.Dynamo_Hatch4_UV, HatchList.Dynamo_Hatch16_UV,
                HatchList.Dynamo_Hatch64_UV, HatchList.Dynamo_Hatch256_UV },

            // Dynamo Hatch UHV
            { HatchList.Dynamo_Hatch_UHV, HatchList.Dynamo_Hatch4_UHV, HatchList.Dynamo_Hatch16_UHV,
                HatchList.Dynamo_Hatch64_UHV, HatchList.Dynamo_Hatch256_UHV },

            // Dynamo Hatch UEV
            { HatchList.Dynamo_Hatch_UEV, HatchList.Dynamo_Hatch4_UEV, HatchList.Dynamo_Hatch16_UEV,
                HatchList.Dynamo_Hatch64_UEV, HatchList.Dynamo_Hatch256_UEV },

            // Dynamo Hatch UIV
            { HatchList.Dynamo_Hatch_UIV, HatchList.Dynamo_Hatch4_UIV, HatchList.Dynamo_Hatch16_UIV,
                HatchList.Dynamo_Hatch64_UIV, HatchList.Dynamo_Hatch256_UIV },

            // Dynamo Hatch UMV
            { HatchList.Dynamo_Hatch_UMV, HatchList.Dynamo_Hatch4_UMV, HatchList.Dynamo_Hatch16_UMV,
                HatchList.Dynamo_Hatch64_UMV, HatchList.Dynamo_Hatch256_UMV },

            // Dynamo Hatch UXV
            { HatchList.Dynamo_Hatch_UXV, HatchList.Dynamo_Hatch4_UXV, HatchList.Dynamo_Hatch16_UXV,
                HatchList.Dynamo_Hatch64_UXV, HatchList.Dynamo_Hatch256_UXV },

            // Laser Source Hatch UV
            { HatchList.Dynamo_Hatch256_UV, HatchList.Laser_Source_Hatch256_UV, HatchList.Laser_Source_Hatch1024_UV,
                HatchList.Laser_Source_Hatch4096_UV, HatchList.Laser_Source_Hatch16384_UV },

            // Laser Target Hatch UV
            { HatchList.Energy_Hatch16_UV, HatchList.Laser_Target_Hatch256_UV, HatchList.Laser_Target_Hatch1024_UV,
                HatchList.Laser_Target_Hatch4096_UV, HatchList.Laser_Target_Hatch16384_UV },

            // Wireless Energy Hatch EV
            { HatchList.Energy_Hatch64_EV, HatchList.Wireless_Energy_Hatch_EV, HatchList.Wireless_Energy_Hatch4_EV,
                HatchList.Wireless_Energy_Hatch16_EV, HatchList.Wireless_Energy_Hatch64_EV, },

            // Wireless Energy Hatch IV
            { HatchList.Energy_Hatch64_IV, HatchList.Wireless_Energy_Hatch_IV, HatchList.Wireless_Energy_Hatch4_IV,
                HatchList.Wireless_Energy_Hatch16_IV, HatchList.Wireless_Energy_Hatch64_IV, },

            // Wireless Energy Hatch LuV
            { HatchList.Energy_Hatch64_LuV, HatchList.Wireless_Energy_Hatch_LuV, HatchList.Wireless_Energy_Hatch4_LuV,
                HatchList.Wireless_Energy_Hatch16_LuV, HatchList.Wireless_Energy_Hatch64_LuV, },

            // Wireless Energy Hatch ZPM
            { HatchList.Energy_Hatch64_ZPM, HatchList.Wireless_Energy_Hatch_ZPM, HatchList.Wireless_Energy_Hatch4_ZPM,
                HatchList.Wireless_Energy_Hatch16_ZPM, HatchList.Wireless_Energy_Hatch64_ZPM, },

            // Wireless Energy Hatch UV
            { HatchList.Energy_Hatch64_UV, HatchList.Wireless_Energy_Hatch_UV, HatchList.Wireless_Energy_Hatch4_UV,
                HatchList.Wireless_Energy_Hatch16_UV, HatchList.Wireless_Energy_Hatch64_UV, },

            // Wireless Energy Hatch UHV
            { HatchList.Energy_Hatch64_UHV, HatchList.Wireless_Energy_Hatch_UHV, HatchList.Wireless_Energy_Hatch4_UHV,
                HatchList.Wireless_Energy_Hatch16_UHV, HatchList.Wireless_Energy_Hatch64_UHV, },

            // Wireless Energy Hatch UEV
            { HatchList.Energy_Hatch64_UEV, HatchList.Wireless_Energy_Hatch_UEV, HatchList.Wireless_Energy_Hatch4_UEV,
                HatchList.Wireless_Energy_Hatch16_UEV, HatchList.Wireless_Energy_Hatch64_UEV, },

            // Wireless Energy Hatch UIV
            { HatchList.Energy_Hatch64_UIV, HatchList.Wireless_Energy_Hatch_UIV, HatchList.Wireless_Energy_Hatch4_UIV,
                HatchList.Wireless_Energy_Hatch16_UIV, HatchList.Wireless_Energy_Hatch64_UIV, },

            // Wireless Energy Hatch UMV
            { HatchList.Energy_Hatch64_UMV, HatchList.Wireless_Energy_Hatch_UMV, HatchList.Wireless_Energy_Hatch4_UMV,
                HatchList.Wireless_Energy_Hatch16_UMV, HatchList.Wireless_Energy_Hatch64_UMV, }, };

        for (int i = 1; i < Tier_4_List.length; i++) {
            for (int j = 0; j < Tier_4_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_4_List[i][j], Tier_4_List[0][j])
                    .itemOutputs(Tier_4_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_4_List_16 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4 },

            // Battery Buffer ULV
            { BlockList.Battery_Buffer1_ULV, BlockList.Battery_Buffer4_ULV, BlockList.Battery_Buffer9_ULV,
                BlockList.Battery_Buffer16_ULV, BlockList.Battery_Charger_ULV },

            // Battery Buffer LV
            { BlockList.Battery_Buffer1_LV, BlockList.Battery_Buffer4_LV, BlockList.Battery_Buffer9_LV,
                BlockList.Battery_Buffer16_LV, BlockList.Battery_Charger_LV },

            // Battery Buffer MV
            { BlockList.Battery_Buffer1_MV, BlockList.Battery_Buffer4_MV, BlockList.Battery_Buffer9_MV,
                BlockList.Battery_Buffer16_MV, BlockList.Battery_Charger_MV },

            // Battery Buffer HV
            { BlockList.Battery_Buffer1_HV, BlockList.Battery_Buffer4_HV, BlockList.Battery_Buffer9_HV,
                BlockList.Battery_Buffer16_HV, BlockList.Battery_Charger_HV },

            // Battery Buffer EV
            { BlockList.Battery_Buffer1_EV, BlockList.Battery_Buffer4_EV, BlockList.Battery_Buffer9_EV,
                BlockList.Battery_Buffer16_EV, BlockList.Battery_Charger_EV },

            // Battery Buffer IV
            { BlockList.Battery_Buffer1_IV, BlockList.Battery_Buffer4_IV, BlockList.Battery_Buffer9_IV,
                BlockList.Battery_Buffer16_IV, BlockList.Battery_Charger_IV },

            // Battery Buffer LuV
            { BlockList.Battery_Buffer1_LuV, BlockList.Battery_Buffer4_LuV, BlockList.Battery_Buffer9_LuV,
                BlockList.Battery_Buffer16_LuV, BlockList.Battery_Charger_LuV },

            // Battery Buffer ZPM
            { BlockList.Battery_Buffer1_ZPM, BlockList.Battery_Buffer4_ZPM, BlockList.Battery_Buffer9_ZPM,
                BlockList.Battery_Buffer16_ZPM, BlockList.Battery_Charger_ZPM },

            // Battery Buffer UV
            { BlockList.Battery_Buffer1_UV, BlockList.Battery_Buffer4_UV, BlockList.Battery_Buffer9_UV,
                BlockList.Battery_Buffer16_UV, BlockList.Battery_Charger_UV },

            // Battery Buffer UHV
            { BlockList.Battery_Buffer1_UHV, BlockList.Battery_Buffer4_UHV, BlockList.Battery_Buffer9_UHV,
                BlockList.Battery_Buffer16_UHV, BlockList.Battery_Charger_UHV },

            // Battery Buffer UEV
            { BlockList.Battery_Buffer1_UEV, BlockList.Battery_Buffer4_UEV, BlockList.Battery_Buffer9_UEV,
                BlockList.Battery_Buffer16_UEV, BlockList.Battery_Charger_UEV },

            // Battery Buffer UIV
            { BlockList.Battery_Buffer1_UIV, BlockList.Battery_Buffer4_UIV, BlockList.Battery_Buffer9_UIV,
                BlockList.Battery_Buffer16_UIV, BlockList.Battery_Charger_UIV },

            // Battery Buffer UMV
            { BlockList.Battery_Buffer1_UMV, BlockList.Battery_Buffer4_UMV, BlockList.Battery_Buffer9_UMV,
                BlockList.Battery_Buffer16_UMV, BlockList.Battery_Charger_UMV },

            // Battery Buffer UXV
            { BlockList.Battery_Buffer1_UXV, BlockList.Battery_Buffer4_UXV, BlockList.Battery_Buffer9_UXV,
                BlockList.Battery_Buffer16_UXV, BlockList.Battery_Charger_UXV }, };

        for (int i = 1; i < Tier_4_List_16.length; i++) {
            for (int j = 0; j < Tier_4_List_16[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_4_List_16[i][j], 16), Tier_4_List_16[0][j])
                    .itemOutputs(setStackSize(Tier_4_List_16[i][j + 1], 16))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_4_List_64 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4 },

            // Monocrystalline Silicon Boule
            { ItemList.Monocrystalline_Silicon_Boule, ItemList.Phosphorus_doped_Monocrystalline_Silicon_Boule,
                ItemList.Naquadah_doped_Monocrystalline_Silicon_Boule,
                ItemList.Europium_doped_Monocrystalline_Silicon_Boule,
                ItemList.Americium_doped_Monocrystalline_Silicon_Boule } };

        for (int i = 1; i < Tier_4_List_64.length; i++) {
            for (int j = 0; j < Tier_4_List_64[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_4_List_64[i][j], 64), Tier_4_List_64[0][j])
                    .itemOutputs(setStackSize(Tier_4_List_64[i][j + 1], 64))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_4_Circuit_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4 },

            // Circuit IV
            { ItemList.Wrap_of_Circuits_IV, ItemList.Mainframe, ItemList.Nano_Supercomputer, ItemList.Quantum_Assembly,
                ItemList.Crystal_Processor },

            // Circuit LuV
            { ItemList.Wrap_of_Circuits_LuV, ItemList.Nano_Mainframe, ItemList.Quantum_Supercomputer,
                ItemList.Crystal_Assembly, ItemList.Wetware_Processor },

            // Circuit ZPM
            { ItemList.Wrap_of_Circuits_ZPM, ItemList.Quantum_Mainframe, ItemList.Crystal_Supercomputer,
                ItemList.Wetware_Assembly, ItemList.Bioware_Processor },

            // Circuit UV
            { ItemList.Wrap_of_Circuits_UV, ItemList.Crystal_Mainframe, ItemList.Wetware_Supercomputer,
                ItemList.Bioware_Assembly, ItemList.Optical_Processor },

            // Circuit UHV
            { ItemList.Wrap_of_Circuits_UHV, ItemList.Wetware_Mainframe, ItemList.Bioware_Supercomputer,
                ItemList.Optical_Assembly, ItemList.Exotic_Processor },

            // Circuit UEV
            { ItemList.Wrap_of_Circuits_UEV, ItemList.Bioware_Mainframe, ItemList.Optical_Supercomputer,
                ItemList.Exotic_Assembly, ItemList.Cosmic_Processor },

            // Circuit UIV
            { ItemList.Wrap_of_Circuits_UIV, ItemList.Optical_Mainframe, ItemList.Exotic_Supercomputer,
                ItemList.Cosmic_Assembly, ItemList.Temporally_Transcendent_Processor } };

        for (int i = 1; i < Tier_4_Circuit_List.length; i++) {
            for (int j = 0; j < Tier_4_Circuit_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_4_Circuit_List[i][0], 64), Tier_4_Circuit_List[0][j])
                    .itemOutputs(setStackSize(Tier_4_Circuit_List[i][j + 1], 1024))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_5_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, },

            // Laser Source Hatch UHV
            { HatchList.Dynamo_Hatch256_UHV, HatchList.Laser_Source_Hatch256_UHV, HatchList.Laser_Source_Hatch1024_UHV,
                HatchList.Laser_Source_Hatch4096_UHV, HatchList.Laser_Source_Hatch16384_UHV,
                HatchList.Laser_Source_Hatch65536_UHV },

            // Laser Target Hatch UHV
            { HatchList.Energy_Hatch16_UHV, HatchList.Laser_Target_Hatch256_UHV, HatchList.Laser_Target_Hatch1024_UHV,
                HatchList.Laser_Target_Hatch4096_UHV, HatchList.Laser_Target_Hatch16384_UHV,
                HatchList.Laser_Target_Hatch65536_UHV } };

        for (int i = 1; i < Tier_5_List.length; i++) {
            for (int j = 0; j < Tier_5_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_5_List[i][j], Tier_5_List[0][j])
                    .itemOutputs(Tier_5_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_5_List_16 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5 },

            // Cable Diode ULV
            { BlockList.Cable_Diode2_ULV, BlockList.Cable_Diode4_ULV, BlockList.Cable_Diode8_ULV,
                BlockList.Cable_Diode12_ULV, BlockList.Cable_Diode16_ULV, BlockList.Energy_Distributor_ULV },

            // Cable Diode LV
            { BlockList.Cable_Diode2_LV, BlockList.Cable_Diode4_LV, BlockList.Cable_Diode8_LV,
                BlockList.Cable_Diode12_LV, BlockList.Cable_Diode16_LV, BlockList.Energy_Distributor_LV },

            // Cable Diode MV
            { BlockList.Cable_Diode2_MV, BlockList.Cable_Diode4_MV, BlockList.Cable_Diode8_MV,
                BlockList.Cable_Diode12_MV, BlockList.Cable_Diode16_MV, BlockList.Energy_Distributor_MV },

            // Cable Diode HV
            { BlockList.Cable_Diode2_HV, BlockList.Cable_Diode4_HV, BlockList.Cable_Diode8_HV,
                BlockList.Cable_Diode12_HV, BlockList.Cable_Diode16_HV, BlockList.Energy_Distributor_HV },

            // Cable Diode EV
            { BlockList.Cable_Diode2_EV, BlockList.Cable_Diode4_EV, BlockList.Cable_Diode8_EV,
                BlockList.Cable_Diode12_EV, BlockList.Cable_Diode16_EV, BlockList.Energy_Distributor_EV },

            // Cable Diode IV
            { BlockList.Cable_Diode2_IV, BlockList.Cable_Diode4_IV, BlockList.Cable_Diode8_IV,
                BlockList.Cable_Diode12_IV, BlockList.Cable_Diode16_IV, BlockList.Energy_Distributor_IV },

            // Cable Diode LuV
            { BlockList.Cable_Diode2_LuV, BlockList.Cable_Diode4_LuV, BlockList.Cable_Diode8_LuV,
                BlockList.Cable_Diode12_LuV, BlockList.Cable_Diode16_LuV, BlockList.Energy_Distributor_LuV },

            // Cable Diode ZPM
            { BlockList.Cable_Diode2_ZPM, BlockList.Cable_Diode4_ZPM, BlockList.Cable_Diode8_ZPM,
                BlockList.Cable_Diode12_ZPM, BlockList.Cable_Diode16_ZPM, BlockList.Energy_Distributor_ZPM },

            // Cable Diode UV
            { BlockList.Cable_Diode2_UV, BlockList.Cable_Diode4_UV, BlockList.Cable_Diode8_UV,
                BlockList.Cable_Diode12_UV, BlockList.Cable_Diode16_UV, BlockList.Energy_Distributor_UV },

            // Cable Diode UHV
            { BlockList.Cable_Diode2_UHV, BlockList.Cable_Diode4_UHV, BlockList.Cable_Diode8_UHV,
                BlockList.Cable_Diode12_UHV, BlockList.Cable_Diode16_UHV, BlockList.Energy_Distributor_UHV },

            // Cable Diode UEV
            { BlockList.Cable_Diode2_UEV, BlockList.Cable_Diode4_UEV, BlockList.Cable_Diode8_UEV,
                BlockList.Cable_Diode12_UEV, BlockList.Cable_Diode16_UEV, BlockList.Energy_Distributor_UEV },

            // Cable Diode UIV
            { BlockList.Cable_Diode2_UIV, BlockList.Cable_Diode4_UIV, BlockList.Cable_Diode8_UIV,
                BlockList.Cable_Diode12_UIV, BlockList.Cable_Diode16_UIV, BlockList.Energy_Distributor_UIV },

            // Cable Diode UMV
            { BlockList.Cable_Diode2_UMV, BlockList.Cable_Diode4_UMV, BlockList.Cable_Diode8_UMV,
                BlockList.Cable_Diode12_UMV, BlockList.Cable_Diode16_UMV, BlockList.Energy_Distributor_UMV },

            // Cable Diode UXV
            { BlockList.Cable_Diode2_UXV, BlockList.Cable_Diode4_UXV, BlockList.Cable_Diode8_UXV,
                BlockList.Cable_Diode12_UXV, BlockList.Cable_Diode16_UXV, BlockList.Energy_Distributor_UXV },

            // Cable Diode MAX
            { BlockList.Cable_Diode2_MAX, BlockList.Cable_Diode4_MAX, BlockList.Cable_Diode8_MAX,
                BlockList.Cable_Diode12_MAX, BlockList.Cable_Diode16_MAX, BlockList.Energy_Distributor_MAX },

            // Filter ULV
            { BlockList.Item_Filter_ULV, BlockList.Type_Filter_ULV, BlockList.Recipe_Filter_ULV,
                BlockList.Item_Distributor_ULV, BlockList.Regulator_ULV, BlockList.Super_Buffer_ULV },

            // Filter LV
            { BlockList.Item_Filter_LV, BlockList.Type_Filter_LV, BlockList.Recipe_Filter_LV,
                BlockList.Item_Distributor_LV, BlockList.Regulator_LV, BlockList.Super_Buffer_LV },

            // Filter MV
            { BlockList.Item_Filter_MV, BlockList.Type_Filter_MV, BlockList.Recipe_Filter_MV,
                BlockList.Item_Distributor_MV, BlockList.Regulator_MV, BlockList.Super_Buffer_MV },

            // Filter HV
            { BlockList.Item_Filter_HV, BlockList.Type_Filter_HV, BlockList.Recipe_Filter_HV,
                BlockList.Item_Distributor_HV, BlockList.Regulator_HV, BlockList.Super_Buffer_HV },

            // Filter EV
            { BlockList.Item_Filter_EV, BlockList.Type_Filter_EV, BlockList.Recipe_Filter_EV,
                BlockList.Item_Distributor_EV, BlockList.Regulator_EV, BlockList.Super_Buffer_EV },

            // Filter IV
            { BlockList.Item_Filter_IV, BlockList.Type_Filter_IV, BlockList.Recipe_Filter_IV,
                BlockList.Item_Distributor_IV, BlockList.Regulator_IV, BlockList.Super_Buffer_IV },

            // Filter LuV
            { BlockList.Item_Filter_LuV, BlockList.Type_Filter_LuV, BlockList.Recipe_Filter_LuV,
                BlockList.Item_Distributor_LuV, BlockList.Regulator_LuV, BlockList.Super_Buffer_LuV },

            // Filter ZPM
            { BlockList.Item_Filter_ZPM, BlockList.Type_Filter_ZPM, BlockList.Recipe_Filter_ZPM,
                BlockList.Item_Distributor_ZPM, BlockList.Regulator_ZPM, BlockList.Super_Buffer_ZPM },

            // Filter UV
            { BlockList.Item_Filter_UV, BlockList.Type_Filter_UV, BlockList.Recipe_Filter_UV,
                BlockList.Item_Distributor_UV, BlockList.Regulator_UV, BlockList.Super_Buffer_UV },

            // Filter UHV
            { BlockList.Item_Filter_UHV, BlockList.Type_Filter_UHV, BlockList.Recipe_Filter_UHV,
                BlockList.Item_Distributor_UHV, BlockList.Regulator_UHV, BlockList.Super_Buffer_UHV } };

        for (int i = 1; i < Tier_5_List_16.length; i++) {
            for (int j = 0; j < Tier_5_List_16[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_5_List_16[i][j], 16), Tier_5_List_16[0][j])
                    .itemOutputs(setStackSize(Tier_5_List_16[i][j + 1], 16))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_6_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, ItemList.UpgradeSmithingTemplate_Tier6 },

            // Laser Source Hatch UEV
            { HatchList.Dynamo_Hatch256_UEV, HatchList.Laser_Source_Hatch256_UEV, HatchList.Laser_Source_Hatch1024_UEV,
                HatchList.Laser_Source_Hatch4096_UEV, HatchList.Laser_Source_Hatch16384_UEV,
                HatchList.Laser_Source_Hatch65536_UEV, HatchList.Laser_Source_Hatch262144_UEV },

            // Laser Target Hatch UEV
            { HatchList.Energy_Hatch16_UEV, HatchList.Laser_Target_Hatch256_UEV, HatchList.Laser_Target_Hatch1024_UEV,
                HatchList.Laser_Target_Hatch4096_UEV, HatchList.Laser_Target_Hatch16384_UEV,
                HatchList.Laser_Target_Hatch65536_UEV, HatchList.Laser_Target_Hatch262144_UEV }, };

        for (int i = 1; i < Tier_6_List.length; i++) {
            for (int j = 0; j < Tier_6_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_6_List[i][j], Tier_6_List[0][j])
                    .itemOutputs(Tier_6_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_7_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, ItemList.UpgradeSmithingTemplate_Tier6,
                ItemList.UpgradeSmithingTemplate_Tier7 },

            // Laser Source Hatch UIV
            { HatchList.Dynamo_Hatch256_UIV, HatchList.Laser_Source_Hatch256_UIV, HatchList.Laser_Source_Hatch1024_UIV,
                HatchList.Laser_Source_Hatch4096_UIV, HatchList.Laser_Source_Hatch16384_UIV,
                HatchList.Laser_Source_Hatch65536_UIV, HatchList.Laser_Source_Hatch262144_UIV,
                HatchList.Laser_Source_Hatch1048576_UIV },

            // Laser Target Hatch UIV
            { HatchList.Energy_Hatch16_UIV, HatchList.Laser_Target_Hatch256_UIV, HatchList.Laser_Target_Hatch1024_UIV,
                HatchList.Laser_Target_Hatch4096_UIV, HatchList.Laser_Target_Hatch16384_UIV,
                HatchList.Laser_Target_Hatch65536_UIV, HatchList.Laser_Target_Hatch262144_UIV,
                HatchList.Laser_Target_Hatch1048576_UIV }, };

        for (int i = 1; i < Tier_7_List.length; i++) {
            for (int j = 0; j < Tier_7_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_7_List[i][j], Tier_7_List[0][j])
                    .itemOutputs(Tier_7_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_7_List_64 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, ItemList.UpgradeSmithingTemplate_Tier6,
                ItemList.UpgradeSmithingTemplate_Tier7 },

            // Item Pipe Casing
            { BlockList.Tin_Item_Pipe_Casing, BlockList.Brass_Item_Pipe_Casing, BlockList.Electrum_Item_Pipe_Casing,
                BlockList.Platinum_Item_Pipe_Casing, BlockList.Osmium_Item_Pipe_Casing,
                BlockList.Quantium_Item_Pipe_Casing, BlockList.Fluxed_Electrum_Item_Pipe_Casing,
                BlockList.Black_Plutonium_Item_Pipe_Casing } };

        for (int i = 1; i < Tier_7_List_64.length; i++) {
            for (int j = 0; j < Tier_7_List_64[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_7_List_64[i][j], 64), Tier_7_List_64[0][j])
                    .itemOutputs(setStackSize(Tier_7_List_64[i][j + 1], 64))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_8_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, ItemList.UpgradeSmithingTemplate_Tier6,
                ItemList.UpgradeSmithingTemplate_Tier7, ItemList.UpgradeSmithingTemplate_Tier8 },

            // Laser Source Hatch UMV
            { HatchList.Dynamo_Hatch256_UMV, HatchList.Laser_Source_Hatch256_UMV, HatchList.Laser_Source_Hatch1024_UMV,
                HatchList.Laser_Source_Hatch4096_UMV, HatchList.Laser_Source_Hatch16384_UMV,
                HatchList.Laser_Source_Hatch65536_UMV, HatchList.Laser_Source_Hatch262144_UMV,
                HatchList.Laser_Source_Hatch1048576_UMV, HatchList.Laser_Source_Hatch4194304_UMV },

            // Laser Target Hatch UMV
            { HatchList.Energy_Hatch16_UMV, HatchList.Laser_Target_Hatch256_UMV, HatchList.Laser_Target_Hatch1024_UMV,
                HatchList.Laser_Target_Hatch4096_UMV, HatchList.Laser_Target_Hatch16384_UMV,
                HatchList.Laser_Target_Hatch65536_UMV, HatchList.Laser_Target_Hatch262144_UMV,
                HatchList.Laser_Target_Hatch1048576_UMV, HatchList.Laser_Target_Hatch4194304_UMV }, };

        for (int i = 1; i < Tier_8_List.length; i++) {
            for (int j = 0; j < Tier_8_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_8_List[i][j], Tier_8_List[0][j])
                    .itemOutputs(Tier_8_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_9_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, ItemList.UpgradeSmithingTemplate_Tier6,
                ItemList.UpgradeSmithingTemplate_Tier7, ItemList.UpgradeSmithingTemplate_Tier8,
                ItemList.UpgradeSmithingTemplate_Tier9 },

            // Capacitor
            { BlockList.Capacitor_Empty, BlockList.Capacitor_EV, BlockList.Capacitor_IV, BlockList.Capacitor_LuV,
                BlockList.Capacitor_ZPM, BlockList.Capacitor_UV, BlockList.Capacitor_UHV, BlockList.Capacitor_UEV,
                BlockList.Capacitor_UIV, BlockList.Capacitor_UMV },

            // Fluid Cell Block
            { BlockList.Fluid_Cell_Block_T1, BlockList.Fluid_Cell_Block_T2, BlockList.Fluid_Cell_Block_T3,
                BlockList.Fluid_Cell_Block_T4, BlockList.Fluid_Cell_Block_T5, BlockList.Fluid_Cell_Block_T6,
                BlockList.Fluid_Cell_Block_T7, BlockList.Fluid_Cell_Block_T8, BlockList.Fluid_Cell_Block_T9,
                BlockList.Fluid_Cell_Block_T10 },

            // T.F.F.T Storage Field Block
            { BlockList.TFFT_Storage_Field_Block_T1, BlockList.TFFT_Storage_Field_Block_T2,
                BlockList.TFFT_Storage_Field_Block_T3, BlockList.TFFT_Storage_Field_Block_T4,
                BlockList.TFFT_Storage_Field_Block_T5, BlockList.TFFT_Storage_Field_Block_T6,
                BlockList.TFFT_Storage_Field_Block_T7, BlockList.TFFT_Storage_Field_Block_T8,
                BlockList.TFFT_Storage_Field_Block_T9, BlockList.TFFT_Storage_Field_Block_T10 } };

        for (int i = 1; i < Tier_9_List.length; i++) {
            for (int j = 0; j < Tier_9_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_9_List[i][j], Tier_9_List[0][j])
                    .itemOutputs(Tier_9_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_9_List_64 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, ItemList.UpgradeSmithingTemplate_Tier6,
                ItemList.UpgradeSmithingTemplate_Tier7, ItemList.UpgradeSmithingTemplate_Tier8,
                ItemList.UpgradeSmithingTemplate_Tier9 },

            // Borosilicate Glass Block
            { BlockList.Borosilicate_Glass_Block, BlockList.Titanium_Reinforced_Borosilicate_Glass_Block,
                BlockList.Tungstensteel_Reinforced_Borosilicate_Glass_Block,
                BlockList.Rhodium_Plated_Palladium_Reinforced_Borosilicate_Glass_Block,
                BlockList.Iridium_Reinforced_Borosilicate_Glass_Block,
                BlockList.Osmium_Reinforced_Borosilicate_Glass_Block,
                BlockList.Neutronium_Reinforced_Borosilicate_Glass_Block,
                BlockList.Cosmic_Neutronium_Reinforced_Borosilicate_Glass_Block,
                BlockList.Infinity_Reinforced_Borosilicate_Glass_Block,
                BlockList.Transcendentally_Reinforced_Borosilicate_Glass_Block } };

        for (int i = 1; i < Tier_9_List_64.length; i++) {
            for (int j = 0; j < Tier_9_List_64[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_9_List_64[i][j], 64), Tier_9_List_64[0][j])
                    .itemOutputs(setStackSize(Tier_9_List_64[i][j + 1], 64))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_10_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, ItemList.UpgradeSmithingTemplate_Tier6,
                ItemList.UpgradeSmithingTemplate_Tier7, ItemList.UpgradeSmithingTemplate_Tier8,
                ItemList.UpgradeSmithingTemplate_Tier9, ItemList.UpgradeSmithingTemplate_Tier10 },

            // Laser Source Hatch UXV
            { HatchList.Dynamo_Hatch256_UXV, HatchList.Laser_Source_Hatch256_UXV, HatchList.Laser_Source_Hatch1024_UXV,
                HatchList.Laser_Source_Hatch4096_UXV, HatchList.Laser_Source_Hatch16384_UXV,
                HatchList.Laser_Source_Hatch65536_UXV, HatchList.Laser_Source_Hatch262144_UXV,
                HatchList.Laser_Source_Hatch1048576_UXV, HatchList.Laser_Source_Hatch4194304_UXV,
                HatchList.Laser_Source_Hatch1677216_UXV, HatchList.Laser_Source_Hatch_Legendary },

            // Laser Target Hatch UXV
            { HatchList.Energy_Hatch16_UXV, HatchList.Laser_Target_Hatch256_UXV, HatchList.Laser_Target_Hatch1024_UXV,
                HatchList.Laser_Target_Hatch4096_UXV, HatchList.Laser_Target_Hatch16384_UXV,
                HatchList.Laser_Target_Hatch65536_UXV, HatchList.Laser_Target_Hatch262144_UXV,
                HatchList.Laser_Target_Hatch1048576_UXV, HatchList.Laser_Target_Hatch4194304_UXV,
                HatchList.Laser_Target_Hatch1677216_UXV, HatchList.Laser_Target_Hatch_Legendary }, };

        for (int i = 1; i < Tier_10_List.length; i++) {
            for (int j = 0; j < Tier_10_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_10_List[i][j], Tier_10_List[0][j])
                    .itemOutputs(Tier_10_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_13_List = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, ItemList.UpgradeSmithingTemplate_Tier6,
                ItemList.UpgradeSmithingTemplate_Tier7, ItemList.UpgradeSmithingTemplate_Tier8,
                ItemList.UpgradeSmithingTemplate_Tier9, ItemList.UpgradeSmithingTemplate_Tier10,
                ItemList.UpgradeSmithingTemplate_Tier11, ItemList.UpgradeSmithingTemplate_Tier12,
                ItemList.UpgradeSmithingTemplate_Tier13 },

            // Wireless Energy Hatch UXV
            { HatchList.Energy_Hatch64_UXV, HatchList.Wireless_Energy_Hatch_UXV, HatchList.Wireless_Energy_Hatch4_UXV,
                HatchList.Wireless_Energy_Hatch16_UXV, HatchList.Wireless_Energy_Hatch64_UXV,
                HatchList.Wireless_Energy_Hatch256_UXV, HatchList.Wireless_Energy_Hatch1024_UXV,
                HatchList.Wireless_Energy_Hatch4096_UXV, HatchList.Wireless_Energy_Hatch16384_UXV,
                HatchList.Wireless_Energy_Hatch65536_UXV, HatchList.Wireless_Energy_Hatch262144_UXV,
                HatchList.Wireless_Energy_Hatch1048576_UXV, HatchList.Wireless_Energy_Hatch4194304_UXV,
                HatchList.Wireless_Energy_Hatch1677216_UXV }, };

        for (int i = 1; i < Tier_13_List.length; i++) {
            for (int j = 0; j < Tier_13_List[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(Tier_13_List[i][j], Tier_13_List[0][j])
                    .itemOutputs(Tier_13_List[i][j + 1])
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }

        ItemStack[][] Tier_13_List_64 = {
            // Upgrade Smithing Template
            { ItemList.UpgradeSmithingTemplate_Tier1, ItemList.UpgradeSmithingTemplate_Tier2,
                ItemList.UpgradeSmithingTemplate_Tier3, ItemList.UpgradeSmithingTemplate_Tier4,
                ItemList.UpgradeSmithingTemplate_Tier5, ItemList.UpgradeSmithingTemplate_Tier6,
                ItemList.UpgradeSmithingTemplate_Tier7, ItemList.UpgradeSmithingTemplate_Tier8,
                ItemList.UpgradeSmithingTemplate_Tier9, ItemList.UpgradeSmithingTemplate_Tier10,
                ItemList.UpgradeSmithingTemplate_Tier11, ItemList.UpgradeSmithingTemplate_Tier12,
                ItemList.UpgradeSmithingTemplate_Tier13 },

            // Circuit IV
            { BlockList.Cupronickel_Coil_Block, BlockList.Kanthal_Coil_Block, BlockList.Nichrome_Coil_Block,
                BlockList.TPVAlloy_Coil_Block, BlockList.HSSG_Coil_Block, BlockList.Naquadah_Coil_Block,
                BlockList.Naquadah_Alloy_Coil_Block, BlockList.Electrum_Flux_Coil_Block,
                BlockList.Awakened_Draconium_Coil_Block, BlockList.HSSS_Coil_Block, BlockList.Trinium_Coil_Block,
                BlockList.Infinity_Coil_Block, BlockList.Hypogen_Coil_Block, BlockList.Eternal_Coil_Block } };

        for (int i = 1; i < Tier_13_List_64.length; i++) {
            for (int j = 0; j < Tier_13_List_64[i].length - 1; j++) {
                GTValues.RA.stdBuilder()
                    .itemInputs(setStackSize(Tier_13_List_64[i][j], 64), Tier_13_List_64[0][j])
                    .itemOutputs(setStackSize(Tier_13_List_64[i][j + 1], 64))
                    .duration(1)
                    .eut(0)
                    .addTo(addUpgraderRecipes);
            }
        }
    }
}
