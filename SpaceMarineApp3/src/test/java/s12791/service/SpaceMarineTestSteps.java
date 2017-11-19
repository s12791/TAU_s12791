package s12791.service;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import s12791.domain.SpaceMarine;

import java.util.List;

public class SpaceMarineTestSteps {

    private SpaceMarineManagerImpl spaceMarineManagerImpl = new SpaceMarineManagerImpl();
    private SpaceMarineAction spaceMarineAction = new SpaceMarineAction();
    private List<SpaceMarine> foundRecords;

    @Given("a data source")
    public void dataSource(){
    	spaceMarineAction.setDataSource(spaceMarineManagerImpl);
    }

    @Given("several Space Marines")
    public void severalSpaceMarines(){
    	spaceMarineManagerImpl.createSpaceMarine(new SpaceMarine("Gabriel", "Thunder Hammer", 5, 5, "Blood Ravens"));
    	spaceMarineManagerImpl.createSpaceMarine(new SpaceMarine("Tarkus", "Bolter", 4, 4, "Blood Ravens"));
    	spaceMarineManagerImpl.createSpaceMarine(new SpaceMarine("Thaddeus", "Chainsword", 4, 4, "Blood Ravens"));
    	spaceMarineManagerImpl.createSpaceMarine(new SpaceMarine("Titus", "Power Axe", 5, 5, "Ultramarines"));
    }

    @When("I'm looking for a Space Marine by regex $regex")
    public void lookingForRecordByRegex(String regex) throws NoSuchFieldException{
        foundRecords = spaceMarineAction.findRecordsByRegex(regex);
    }

    @Then("Then objects should be found $num")
    public void recordShouldBeFound(int num){
        Assert.assertTrue(foundRecords.size() >= 1);
    }
}

