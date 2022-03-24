/*
 *  Justian Tremblay | 040968930
 *  SpriteFacade.java
 *  Purose: SpriteFacade is the session facade and is used to encapsulate interactions with the database
 */
package cst8218.trem0354.entity;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tgk
 */
@Stateless
public class SpriteFacade extends AbstractFacade<Sprite> {
    @PersistenceContext(unitName = "SpriteJustain-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpriteFacade() {
        super(Sprite.class);
    }
    
}

