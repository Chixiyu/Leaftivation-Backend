# Leaftivation

## Home page 

### Introduction
**/introduction** 

return:
- String (introduction word)

### User's current point
**/currentPoint?userId=____**

param:
- userId

return:
- Double (the point of given username)

### Leaderboard
**/leaderboard?first=___&last=**

E.g: 0-20 (**important: index start from 0!**)
param:
- first person
- last person

return:
- List containing:
  - String username
  - String avatarImageLocation
  - Int point awarded


##  Awards list page
### List of awards

**/award/get**

params:
- choice
  - 1: select awards by time descending order
  - 2: select awards by time ascending order
  - 3: select awards by price descending order
  - 4: select awards by price ascending order
  - 5: select awards by name descending order
  - 6: select awards by name ascending order
- int first
- int last

return:
- List containing:
  - Long id
  - String name
  - Double price
  - String description
  - String collaborator

### User's current point

~~ same as above

**/point/current**
params:
- Long userId

return:
- Double point

## Single Award page
**/award/select**

params:
- int id (award id)

return:
- Award containing:
  - Long id
  - String name
  - Double price
  - String description
  - String collaborator

### Add to cart button
**/cart/add**
params:
- Long userId
- Long awardId
- int count (how many of this award added?)
- 
return:
- boolean (successful or not)

## Cart page
### Cart list
**/cart/getCart**

params:
- Long userId

return:
- A list containing
  - Long id
  - String name 
  - Double price
  - String description
  - String imagePosition 
  - String collaborator
  - Date uploadTime
  - Long count

### Sum of Price
**/cart/totalPrice**

params:
- Long userId

return:
- Double price

### Purchase the cart
**/cart/purchase**

params:
- Long userId

return:
- String, response will be:
  - "Successful"
  - "You don't have enough points, you still need ___ points"

## Log page

### upload log
**/upload/log**

params:
- Long userId
- int transportationType
- Long amount

return:
- Long **logId** (IMPORTANT, need to be saved securely, used to get other info)

### uploadPicture
**/upload/picture**

param:
- Long logId 
- MultipartFile file
- String userName

return:
- true(success)/false(upload failed)

### get all logs (logging history)
**/upload/allLogs**

params:
- Long userId

return:
- List containing
  - boolean audit 
  - Long userId 
  - Date logTime 
  - int transportationType 
  - Double amount 
  - Long pictureId 
  - Long LogId 
  - String picturePosition

### delete log
**/upload/delete/log**

param:
- Long userId
- Long logId

return:
- true/false

### deletePicture
**/upload/delete/picture**

param:
- Long logId
- Long pictureId

return:
- true/false
