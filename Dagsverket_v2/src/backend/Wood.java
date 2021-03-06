/*
  _______ ______          __  __   _______ ____  ____  ____  
 |__   __|  ____|   /\   |  \/  | |__   __/ __ \|  _ \|  _ \ 
    | |  | |__     /  \  | \  / |    | | | |  | | |_) | |_) |
    | |  |  __|   / /\ \ | |\/| |    | | | |  | |  _ <|  _ < 
    | |  | |____ / ____ \| |  | |    | | | |__| | |_) | |_) |
    |_|  |______/_/    \_\_|  |_|    |_|  \____/|____/|____/                                                            
*/
package backend;

public class Wood {
    private String woodType;
    private int bagSize;
    private int price;

    public Wood(String woodType, int bagSize, int price) {
    	this.woodType = woodType;
    	this.bagSize = bagSize;
    	this.price = price;
    }

    public String getWoodType() {
    	return this.woodType;
    }

    public int getBagSize() {
    	return this.bagSize;
    }

    public int getPrice() {
    	return this.price;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public void setBagSize(int bagSize) {
        this.bagSize = bagSize;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
