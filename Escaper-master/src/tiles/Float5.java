/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import gfx.Assets;

/**
 *
 * @author archit
 */
public class Float5 extends Tile {

    public Float5(int id) {
        super(Assets.float5, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
}
