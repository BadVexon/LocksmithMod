package theAnime.patches;

import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import theAnime.AnimeMod;
import theAnime.cardmods.LockedMod;

public class LockedOrbPatch {
    private static TextureAtlas.AtlasRegion imaginOrb1 = AnimeMod.UIAtlas.findRegion("lockOrb");
    private static Color myColorOne = new Color(1.0F, 0.3F, 0.3F, 1.0F);
    private static Color myColorTwo = new Color(0.4F, 1.0F, 0.4F, 1.0F);// 201

    @SpirePatch(clz = AbstractCard.class, method = "renderEnergy")
    public static class SecondEnergyRenderPatch {
        public static void Postfix(AbstractCard __instance, SpriteBatch sb) {
            if (__instance.cost > -2 && !__instance.isLocked && __instance.isSeen) {// 2706
                if (CardModifierManager.hasModifier(__instance, LockedMod.ID)) {
                    for (AbstractCardModifier q : CardModifierManager.getModifiers(__instance, LockedMod.ID)) {
                        if (q instanceof LockedMod) {
                            Color g = Color.WHITE.cpy();
                            g.a = __instance.transparency;
                            renderHelper(sb, g, imaginOrb1, __instance.current_x, __instance.current_y, __instance);
                            Color costColor = Color.WHITE.cpy();// 2731
                            if (AbstractDungeon.player != null && AbstractDungeon.player.hand.contains(__instance) && !hasEnoughKeys(((LockedMod) q).amount) && !__instance.freeToPlayOnce) {// 2732
                                costColor = myColorOne;
                            } else if (__instance.freeToPlayOnce || ((LockedMod) q).unlocked) {// 2734
                                costColor = myColorTwo;
                            }

                            costColor.a = __instance.transparency;// 2737
                            String text = Integer.toString(((LockedMod) q).amount);
                            if (__instance.freeToPlayOnce || ((LockedMod) q).unlocked) {
                                text = "0";
                            }
                            FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, text, __instance.current_x, __instance.current_y,
                                    -135.0F * __instance.drawScale * Settings.scale,
                                    85.0F * __instance.drawScale * Settings.scale,
                                    __instance.angle, false, costColor);
                        }
                    }
                }
            }
        }

        private static String getCost(AbstractCard q) {
            if (q.cost == -1) {// 2855
                return "X";// 2856
            } else {
                return q.freeToPlay() ? "0" : Integer.toString(q.costForTurn);// 2857 2858 2860
            }
        }

        private static boolean hasEnoughKeys(int q) {
            return ((AbstractDungeon.player.hand.group.stream().filter(c -> c.hasTag(AnimeMod.KEY)).count() >= q));
        }

        private static void renderHelper(SpriteBatch sb, Color color, TextureAtlas.AtlasRegion img, float drawX, float drawY, AbstractCard q) {
            sb.setColor(color);// 1427
            sb.draw(img, drawX + img.offsetX - (float) img.originalWidth / 2.0F, drawY + img.offsetY - (float) img.originalHeight / 2.0F, (float) img.originalWidth / 2.0F - img.offsetX, (float) img.originalHeight / 2.0F - img.offsetY, (float) img.packedWidth, (float) img.packedHeight, q.drawScale * Settings.scale, q.drawScale * Settings.scale, q.angle);// 1428
        }// 1439

        private static BitmapFont getEnergyFont(AbstractCard q) {
            FontHelper.cardEnergyFont_L.getData().setScale(q.drawScale);// 2877
            return FontHelper.cardEnergyFont_L;// 2878
        }
    }
}