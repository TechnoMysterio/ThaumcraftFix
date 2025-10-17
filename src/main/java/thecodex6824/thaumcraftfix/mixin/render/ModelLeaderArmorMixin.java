package thecodex6824.thaumcraftfix.mixin.render;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import thaumcraft.client.renderers.models.gear.ModelLeaderArmor;

@Mixin(ModelLeaderArmor.class)
public class ModelLeaderArmorMixin extends ModelBiped {

    @Shadow(remap = false)
    private ModelRenderer ShoulderL;

    @Inject(
	    method = "<init>(F)V",
	    at = @At(
		    value = "INVOKE",
		    target = "Lnet/minecraft/client/model/ModelRenderer;addBox(FFFIII)Lnet/minecraft/client/model/ModelRenderer;",
		    ordinal = 34
		    ),
	    remap = false
	    )
    private void fixupLeftShoulderTexture(CallbackInfo info) {
	ShoulderL.mirror = true;
    }

}
