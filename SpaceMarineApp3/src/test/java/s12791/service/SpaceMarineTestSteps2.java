package s12791.service;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import s12791.domain.SpaceMarine;

import java.util.ArrayList;
import java.util.List;

public class SpaceMarineTestSteps2 {

    private SpaceMarineManagerImpl spaceMarineManagerImpl = new SpaceMarineManagerImpl();
    private SpaceMarineAction spaceMarineAction = new SpaceMarineAction();

    List<SpaceMarine> repo = new ArrayList<SpaceMarine>();
    List<SpaceMarine> smList = new ArrayList<SpaceMarine>();

    @Given("a data source")
    public void dataSource(){
    	spaceMarineAction.setDataSource(spaceMarineManagerImpl);
    }

    @Given("4 Space Marines")
    public void severalSpaceMarines(){
    	spaceMarineManagerImpl.createSpaceMarine(new SpaceMarine("Gabriel", "Thunder Hammer", 5, 5, "Blood Ravens"));
    	spaceMarineManagerImpl.createSpaceMarine(new SpaceMarine("Tarkus", "Bolter", 4, 4, "Blood Ravens"));
    	spaceMarineManagerImpl.createSpaceMarine(new SpaceMarine("Thaddeus", "Chainsword", 4, 4, "Blood Ravens"));
    	spaceMarineManagerImpl.createSpaceMarine(new SpaceMarine("Titus", "Power Axe", 5, 5, "Ultramarines"));
    }

    @When("I'm deleting a space marine")
    public void deleteRecordAsList() throws NoSuchFieldException{
    	
    	List<SpaceMarine> smList = new ArrayList<SpaceMarine>();
    	SpaceMarine sm1 = new SpaceMarine("Gabriel", "Thunder Hammer", 5, 5, "Blood Ravens");
		smList.add(0, sm1);

    	spaceMarineAction.deleteSpaceMarines(smList);
    }

    @Then("3 Space Marine object should be found")
    public void recordsShouldBeFound(){
        Assert.assertTrue(spaceMarineManagerImpl.getAllSpaceMarines().size()==3);
    }

}

