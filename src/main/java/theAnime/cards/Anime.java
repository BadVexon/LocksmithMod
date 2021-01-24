package theAnime.cards;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.cardmods.KeybladeModifier;

public class Anime extends AbstractTodoCard {

    public final static String ID = makeID("Anime");

    //stupid intellij stuff SKILL, SELF, UNCOMMON

    private static final int MAGIC = 7;
    private static final int UPG_MAGIC = 5;

    public Anime() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = MAGIC;
        AbstractCard q = new Key();
        CardModifierManager.addModifier(q, new KeybladeModifier(magicNumber));
        cardsToPreview = q;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        genKey(1);
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                isDone = true;
                for (AbstractCard q : AbstractDungeon.player.hand.group) {
                    if (q.hasTag(AnimeMod.KEY)) {
                        CardModifierManager.addModifier(q, new KeybladeModifier(magicNumber));
                        q.superFlash();
                    }
                }
            }
        });
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
        AbstractCard q = new Key();
        CardModifierManager.addModifier(q, new KeybladeModifier(magicNumber));
        cardsToPreview = q;
    }
}