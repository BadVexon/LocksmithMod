package theAnime.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class SearchDummyAction extends AbstractGameAction {
    private AbstractPlayer p;

    public SearchDummyAction(int hp) {
        this.p = AbstractDungeon.player;
        amount = hp;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_FASTER;
    }

    public void update() {
        if (AbstractDungeon.getCurrRoom().isBattleEnding()) {
            this.isDone = true;
        } else {
            if (this.duration == Settings.ACTION_DUR_FASTER) {
                if (this.p.drawPile.isEmpty()) {
                    this.isDone = true;
                    return;
                }

                if (this.p.drawPile.size() == 1) {
                    AbstractCard tmp = this.p.drawPile.getTopCard();
                    this.p.drawPile.removeCard(tmp);
                    addToTop(new SummonDummyAction(SummonDummyAction.DummyTypes.STASIS, amount, -1, tmp));
                }

                if (this.p.drawPile.group.size() > 1) {
                    AbstractDungeon.gridSelectScreen.open(this.p.drawPile, 1, "Choose a card to attach to the Dummy.", false, false, false, false);
                    this.tickDuration();
                    return;
                }
            }

            if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {

                for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
                    this.p.drawPile.removeCard(c);
                    addToTop(new SummonDummyAction(SummonDummyAction.DummyTypes.STASIS, amount, -1, c));
                }

                AbstractDungeon.gridSelectScreen.selectedCards.clear();
                AbstractDungeon.player.hand.refreshHandLayout();
            }

            this.tickDuration();
        }
    }
}
