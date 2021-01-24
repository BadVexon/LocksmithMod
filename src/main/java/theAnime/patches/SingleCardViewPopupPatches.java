package theAnime.patches;

import basemod.ReflectionHacks;
import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.screens.SingleCardViewPopup;
import theAnime.AnimeMod;
import theAnime.cardmods.LockedMod;

public class SingleCardViewPopupPatches {
    private static TextureAtlas.AtlasRegion bigImaginOrb = AnimeMod.UIAtlas.findRegion("bigLock");

    @SpirePatch(clz = SingleCardViewPopup.class, method = "renderCost")
    public static class RenderSecondCostPatch {
        private static void renderHelper(SpriteBatch sb, float x, float y, TextureAtlas.AtlasRegion img) {
            if (img != null) {
                sb.draw(img, x + img.offsetX - (float) img.originalWidth / 2.0F, y + img.offsetY - (float) img.originalHeight / 2.0F, (float) img.originalWidth / 2.0F - img.offsetX, (float) img.originalHeight / 2.0F - img.offsetY, (float) img.packedWidth, (float) img.packedHeight, Settings.scale, Settings.scale, 0.0F);
            }
        }

        @SpirePostfixPatch
        public static void patch(SingleCardViewPopup __instance, SpriteBatch sb) {
            AbstractCard C = (AbstractCard) ReflectionHacks.getPrivate(__instance, SingleCardViewPopup.class, "card");
            if (CardModifierManager.hasModifier(C, LockedMod.ID)) {
                for (AbstractCardModifier q : CardModifierManager.getModifiers(C, LockedMod.ID)) {
                    if (q instanceof LockedMod) {
                        renderHelper(sb, (float) Settings.WIDTH / 2.0F - 115 * Settings.scale, (float) Settings.HEIGHT / 2.0F - 94.0F * Settings.scale, bigImaginOrb);
                        FontHelper.renderFont(sb, FontHelper.SCP_cardEnergyFont, Integer.toString(((LockedMod) q).amount), (float) Settings.WIDTH / 2.0F - 300 * Settings.scale, (float) Settings.HEIGHT / 2.0F + 88F * Settings.scale, Color.WHITE);
                    }
                }
            }
        }
    }
}