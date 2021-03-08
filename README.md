# registration
This is a simple spring boot application for vehicle registrations
# usage
there are APIs for the registration of vehicles and owners.
# show all the registrations
/registrations/all
# register the vehicle with the owner with POST method
/registrations/register
sample json: 
{
    "vehicleID": "fiat",
    "ownerID": "John Doe"
}

# show all the owners
/owners/all
# register an owner with POST method
/owners/register
sample json: 
 {  
        "name": "Jason Doe"
 }

# show all the vehicles
/vehicles/all
# register an vehicle with POST method
/vehicles/register
sample json:
{
    "vehicleID": "someCarID",
    "model": "bmw-x3"
}
