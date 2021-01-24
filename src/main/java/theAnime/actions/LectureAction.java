package theAnime.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theAnime.cards.AbstractTodoCard;

public class LectureAction extends AbstractGameAction {
    public void update() {
        int theSize = AbstractDungeon.player.hand.size();// 19
        for (AbstractMonster q : AbstractTodoCard.monsterList()) {
            addToTop(new ApplyPowerAction(q, AbstractDungeon.player, new StrengthPower(q, -theSize), -theSize));
        }

        this.addToTop(new ExhaustAction(AbstractDungeon.player, AbstractDungeon.player, theSize, false));// 29
        this.isDone = true;// 31
    }// 32
}
