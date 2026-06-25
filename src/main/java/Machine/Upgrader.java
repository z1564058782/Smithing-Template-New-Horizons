package Machine;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.*;
import static gregtech.api.enums.HatchElement.*;
import static gregtech.api.enums.Textures.BlockIcons.*;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import Recipes.UpgraderRecipes;
import gregtech.api.casing.Casings;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.MTEExtendedPowerMultiBlockBase;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.render.TextureFactory;
import gregtech.api.structure.error.StructureError;
import gregtech.api.structure.error.StructureErrorRegistry;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.MultiblockTooltipBuilder;

public class Upgrader extends MTEExtendedPowerMultiBlockBase<Upgrader> implements ISurvivalConstructable {

    public Upgrader(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public Upgrader(String aName) {
        super(aName);
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
    }

    // 定义机器结构
    private static final String STRUCTURE_PIECE_MAIN = "main";
    private static final IStructureDefinition<Upgrader> STRUCTURE_DEFINITION = StructureDefinition.<Upgrader>builder()
        .addShape(
            STRUCTURE_PIECE_MAIN,
            transpose(new String[][] { { "hhh", "hhh", "hhh" }, { "h~h", "h h", "hhh" }, { "hhh", "hhh", "hhh" } }))
        .addElement(
            'h',
            buildHatchAdder(Upgrader.class).atLeast(InputBus, OutputBus, Maintenance)
                .casingIndex(Casings.SolidSteelMachineCasing.textureId)
                .hint(1)
                .buildAndChain(onElementPass(Upgrader::onCasingAdded, Casings.SolidSteelMachineCasing.asElement())))
        .build();

    @Override
    public RecipeMap<?> getRecipeMap() {
        return UpgraderRecipes.addUpgraderRecipes;
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic() {

            @Override
            public @NotNull CheckRecipeResult process() {
                setSpeedBonus(1.0);
                enablePerfectOverclock();
                return super.process();
            }

            @Override
            protected @NotNull CheckRecipeResult onRecipeStart(@NotNull GTRecipe recipe) {
                return CheckRecipeResultRegistry.SUCCESSFUL;
            }
        }.setMaxParallel(Integer.MAX_VALUE);
    }

    private int mCasingAmount;

    private void onCasingAdded() {
        mCasingAmount++;
    }

    @Override
    public IStructureDefinition<Upgrader> getStructureDefinition() {
        return STRUCTURE_DEFINITION;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection aFacing,
        int colorIndex, boolean aActive, boolean redstoneLevel) {
        if (side == aFacing) {
            if (aActive) {
                return new ITexture[] { Casings.SolidSteelMachineCasing.getCasingTexture(), TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_ORE_FACTORY_ACTIVE)
                    .extFacing()
                    .build(),
                    TextureFactory.builder()
                        .addIcon(OVERLAY_FRONT_ORE_FACTORY_ACTIVE_GLOW)
                        .extFacing()
                        .glow()
                        .build() };
            }
            return new ITexture[] { Casings.SolidSteelMachineCasing.getCasingTexture(), TextureFactory.builder()
                .addIcon(OVERLAY_FRONT_ORE_FACTORY)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_ORE_FACTORY_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
        }
        return new ITexture[] { Casings.SolidSteelMachineCasing.getCasingTexture() };
    }

    // 主机ToolTips
    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        final MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType("Upgrader")
            .addInfo("Use Upgrade Smithing Template")
            .addInfo("Add By: Smithing Template New Horizons")
            .beginStructureBlock(3, 3, 3, true)
            .addController("Front center")
            .addCasingInfoRange("Solid Steel Machine Casing", 4, 24, false)
            .addMaintenanceHatch("Any casing", 1)
            .addInputBus("Any casing", 1)
            .addOutputBus("Any casing", 1)
            .toolTipFinisher();
        return tt;
    }

    // 创造自动搭建
    @Override
    public void construct(ItemStack aStack, boolean aHintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, aStack, aHintsOnly, 1, 1, 0);
    }

    // 生存自动搭建
    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) {
            return -1;
        }
        return survivalBuildPiece(STRUCTURE_PIECE_MAIN, stackSize, 1, 1, 0, elementBudget, env, false, true);
    }

    public void checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack, List<StructureError> errors) {
        if (errors == null) {
            return;
        }

        this.mMaintenanceHatches.clear();
        this.mOutputBusses.clear();
        mCasingAmount = 0;

        boolean isMainStructureValid = checkPiece(STRUCTURE_PIECE_MAIN, 1, 1, 0, errors);

        if (!isMainStructureValid) {
            return;
        }

        if (mCasingAmount < 4) {
            errors.add(StructureErrorRegistry.UNKNOWN_STRUCTURE_ERROR);
            return;
        }

        if (mMaintenanceHatches.size() != 1) {
            errors.add(StructureErrorRegistry.UNKNOWN_STRUCTURE_ERROR);
        }
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        return 0;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new Upgrader(this.mName);
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
    }
}
