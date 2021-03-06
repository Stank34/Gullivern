package net.teamfruit.gulliver.compatibilities;

import net.teamfruit.gulliver.compatibilities.sizeCap.ISizeCap;
import net.teamfruit.gulliver.compatibilities.sizeCap.SizeCapPro;
import net.teamfruit.gulliver.compatibilities.sizeCap.SizeDefaultCap;
import net.teamfruit.gulliver.Gulliver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilitiesHandler {

    @SubscribeEvent
    public void onAddCapabilites(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof LivingEntity && !event.getObject().getCapability(SizeCapPro.sizeCapability).isPresent()) {
            final LivingEntity entity = (LivingEntity) event.getObject();
            final boolean transformed = false;
            final float defaultWidth = entity.getWidth();
            final float defaultHeight = entity.getHeight();
            final ISizeCap cap = new SizeDefaultCap(transformed, defaultWidth, defaultHeight);
            event.addCapability(new ResourceLocation(Gulliver.MODID, "capability"), new SizeCapPro(cap));
        }
    }
}
