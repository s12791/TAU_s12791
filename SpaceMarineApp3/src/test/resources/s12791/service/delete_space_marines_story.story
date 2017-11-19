
Meta:

Narrative:

As a spaceMarineApp user: 

I want to find the Space Marine from database
The Space Marine must be from a specific chapter. 

Scenario: Delete Space Marines by list
Given a data source
And 4 Space Marines
When I'm deleting a space marine
Then 3 Space Marine object should be found