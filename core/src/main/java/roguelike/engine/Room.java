package roguelike.engine;

import lombok.Getter;
import lombok.Setter;
import roguelike.utilities.Roll;

@Getter @Setter
public class Room {
    private Point topLeft;
    private Point bottomRight;

    public Room(int x, int y, int width, int height){
        this.topLeft = new Point(x, y);
        this.bottomRight = new Point(x + width - 1, y + height - 1);
    }

    public boolean intersects(Room second){
        /*if(topLeft.x + 1 > second.getBottomRight().x || second.getTopLeft().x + 1 > bottomRight.x)
            return false;

        if(topLeft.y + 1 < second.bottomRight.y || second.getTopLeft().y + 1 < bottomRight.y)
            return false;

        return true;*/

        return (this.getTopLeft().x <= second.bottomRight.x + Roll.rand(3, 5)) && (this.getBottomRight().x + Roll.rand(3, 5) >= second.getTopLeft().x) && (this.getTopLeft().y <= second.getBottomRight().y + Roll.rand(3, 5)) && (this.getBottomRight().y + Roll.rand(3, 5) >= second.getTopLeft().y);
    }
}