/*
 * Agnes@needemand
 */
package tools;

import views.BeanFeature;

/**
 *
 * @author agnes
 */
public class MyFeature {
    
    private String name; // Hungry - faim
    private int miniValue; // 0
    private int maxValue; // 10
    private int value; // 5
    
    /**
     * @param name
     * @param miniValue
     * @param maxValue
     * @param defaultValue
     */
    public MyFeature(String name, int miniValue, int maxValue, int defaultValue) {
        this.name = name;
        this.miniValue = miniValue;
        this.maxValue = maxValue;
        this.value = defaultValue;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getMiniValue() {
        return miniValue;
    }
    
    public void setMiniValue(int miniValue) {
        this.miniValue = miniValue;
    }
    
    public int getMaxValue() {
        return maxValue;
    }
    
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        if (value > this.maxValue) {
            value = this.maxValue;
        } else if (value < this.miniValue) {
            value = this.miniValue;
        }
        this.value = value;
    }
    
    @Override
    public String toString() {
        return this.name + " : " + this.value;
    }
    
    public void sub(int i) {
        this.setValue(this.value - i);
    }
    
    public void add(int i) {
        this.setValue(this.value + i);
    }
    
    public boolean isMax(){
        return this.value >= this.maxValue;
    }
    
    public boolean isMin(){
        return this.value <= this.miniValue;
    }

    public void synchronise(BeanFeature beanFeatureHungry) {
        beanFeatureHungry.setTitle(this.name);
        beanFeatureHungry.setVal(this.value);
    }
    
}
