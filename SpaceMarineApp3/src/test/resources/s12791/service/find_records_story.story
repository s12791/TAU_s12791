
Meta:

Narrative:

As a spaceMarineApp user: 

I want to find the Space Marine from database
The Space Marine must be from a specific chapter. 

Scenario: Find specific record from all Space Marines
Given a data source
And several Space Marines
When I'm looking for a Space Marine by regex
|regex       |
|Ultramarines|
|Blood Ravens|

Then objects should be found

Examples: 
|regex       | num |
|Ultramarines|  1  |
|Blood Ravens|  3  |