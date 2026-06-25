package RecipesFrontend;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import com.gtnewhorizons.modularui.api.math.Pos2d;
import com.gtnewhorizons.modularui.api.math.Size;
import com.gtnewhorizons.modularui.api.screen.ModularWindow;
import com.gtnewhorizons.modularui.common.widget.ProgressBar;

import gregtech.api.gui.modularui.GTUITextures;
import gregtech.api.recipe.BasicUIPropertiesBuilder;
import gregtech.api.recipe.NEIRecipePropertiesBuilder;
import gregtech.api.recipe.RecipeMapFrontend;
import gregtech.api.util.MethodsReturnNonnullByDefault;
import gregtech.common.gui.modularui.UIHelper;
import gregtech.nei.GTNEIDefaultHandler;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class UpgraderFrontend extends RecipeMapFrontend {

    public UpgraderFrontend(BasicUIPropertiesBuilder uiPropertiesBuilder,
        NEIRecipePropertiesBuilder neiRecipePropertiesBuilder) {
        super(
            uiPropertiesBuilder.logoPos(new Pos2d(8, 8)),
            neiRecipePropertiesBuilder.recipeBackgroundSize(new Size(170, 96)));
    }

    @Override
    public List<Pos2d> getItemInputPositions(int itemInputCount) {
        return UIHelper.getGridPositions(itemInputCount, 40, 40, 2, 1);
    }

    public List<Pos2d> getItemOutputPositions(int itemOutputCount) {
        return UIHelper.getGridPositions(itemOutputCount, 115, 40, 1, 1);
    }

    public List<Pos2d> getFluidInputPositions(int fluidInputCount) {
        return UIHelper.getGridPositions(fluidInputCount, 0, 0, 0, 0);
    }

    public List<Pos2d> getFluidOutputPositions(int fluidOutputCount) {
        return UIHelper.getGridPositions(fluidOutputCount, 0, 0, 0, 0);
    }

    public void addProgressBar(ModularWindow.Builder builder, GTNEIDefaultHandler.NEITemplateContext ctx) {
        builder.widget(
            (new ProgressBar()).setTexture(GTUITextures.PROGRESSBAR_ARROW, 16)
                .setDirection(ProgressBar.Direction.RIGHT)
                .setProgress(ctx.progressSupplier)
                .setSynced(false, false)
                .setPos((new Pos2d(85, 42)).add(ctx.windowOffset))
                .setSize(20, 16));
    }
}
