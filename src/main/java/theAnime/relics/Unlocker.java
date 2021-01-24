package theAnime.relics;

import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardBrieflyEffect;
import theAnime.TheAnime;
import theAnime.cardmods.LockedMod;

import java.util.ArrayList;

public class Unlocker extends AbstractTodoRelic {
    public static final String ID = makeID("Unlocker");

    public Unlocker() {
        super(ID, RelicTier.RARE, LandingSound.MAGICAL, TheAnime.Enums.LOCKSMITH_COLOR);
    }

    @Override
    public void atBattleStartPreDraw() {
        flash();
        ArrayList<AbstractCard> possCardsList = new ArrayList<>();
        for (AbstractCard q : AbstractDungeon.player.drawPile.group) {
            if (CardModifierManager.hasModifier(q, LockedMod.ID)) {
                possCardsList.add(q);
            }
        }
        AbstractCard r = possCardsList.get(AbstractDungeon.cardRandomRng.random(possCardsList.size() - 1));
        for (AbstractCardModifier w : CardModifierManager.getModifiers(r, LockedMod.ID)) {
            if (w instanceof LockedMod) {
                ((LockedMod) w).unlocked = true;
            }
        }
        AbstractDungeon.effectList.add(new ShowCardBrieflyEffect(r.makeStatEquivalentCopy()));
    }
}
