package mekhq.campaign.mission;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains parameters useful for maps generated by atb-stratcon maps
 * @author NickAragua
 */
public class ScenarioMapParameters implements Cloneable {
    public enum MapLocation {
        AllGroundTerrain,
        SpecificGroundTerrain,
        Space,
        LowAtmosphere
    }

    @Override
    public ScenarioMapParameters clone() {
        ScenarioMapParameters clone = new ScenarioMapParameters();
        clone.allowedTerrainTypes = new ArrayList<>(allowedTerrainTypes);
        clone.allowRotation = allowRotation;
        clone.baseHeight = baseHeight;
        clone.baseWidth = baseWidth;
        clone.heightScalingIncrement = heightScalingIncrement;
        clone.mapLocation = mapLocation;
        clone.useStandardAtBSizing = useStandardAtBSizing;
        clone.widthScalingIncrement = widthScalingIncrement;

        return clone;
    }

    /**
     * The fixed base width/x dimension of the map.
     */
    private int baseWidth;

    /**
     * The fixed base height/y dimension of the map.
     */
    private int baseHeight;

    /**
     * If the player deploys a force larger than a lance, the map will grow horizontally by this many hexes per extra lance
     */
    private int widthScalingIncrement = 5;

    /**
     * If the player deploys a force larger than a lance, the map will grow vertically by this many hexes per extra lance
     */
    private int heightScalingIncrement = 5;

    /**
     * Allow the map to potentially (with 50/50 odds) to be rotated 90 degrees.
     */
    private boolean allowRotation;

    /**
     * Use the AtB Map Sizes table to determine the base width and height of the map.
     */
    private boolean useStandardAtBSizing;

    /**
     * What kind of map it should be: space, low atmo, any ground map, specific ground map
     */
    private MapLocation mapLocation;

    @XmlElementWrapper(name="allowedTerrainTypes")
    @XmlElement(name="allowedTerrainType")
    public List<String> allowedTerrainTypes = new ArrayList<>();

    public List<String> getAllowedTerrainType() {
        return allowedTerrainTypes;
    }

    public int getBaseWidth() {
        return baseWidth;
    }

    public void setBaseWidth(int baseWidth) {
        this.baseWidth = baseWidth;
    }

    public int getBaseHeight() {
        return baseHeight;
    }

    public void setBaseHeight(int baseHeight) {
        this.baseHeight = baseHeight;
    }

    public int getWidthScalingIncrement() {
        return widthScalingIncrement;
    }

    public void setWidthScalingIncrement(int widthScalingIncrement) {
        this.widthScalingIncrement = widthScalingIncrement;
    }

    public int getHeightScalingIncrement() {
        return heightScalingIncrement;
    }

    public void setHeightScalingIncrement(int heightScalingIncrement) {
        this.heightScalingIncrement = heightScalingIncrement;
    }

    public boolean isAllowRotation() {
        return allowRotation;
    }

    public void setAllowRotation(boolean allowRotation) {
        this.allowRotation = allowRotation;
    }

    public boolean isUseStandardAtBSizing() {
        return useStandardAtBSizing;
    }

    public void setUseStandardAtBSizing(boolean useStandardAtBSizing) {
        this.useStandardAtBSizing = useStandardAtBSizing;
    }

    public MapLocation getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(MapLocation mapLocation) {
        this.mapLocation = mapLocation;
    }
}
