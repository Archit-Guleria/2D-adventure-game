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
public class Underground4 extends Tile {

    public Underground4(int id) {
        super(Assets.underground4, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
}
