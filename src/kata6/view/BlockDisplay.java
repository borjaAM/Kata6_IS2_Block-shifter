package kata6.view;

import kata6.model.Block;

/**
 *
 * @author Usuario
 */
public interface BlockDisplay extends Block.Observer{
    public void display(Block block);
    public Block block();
}
