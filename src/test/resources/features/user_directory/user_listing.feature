Feature: Listing User
  @current
  Rule: Should be able to list users in the directory
  Example: Users are presented in the paginated format
    Given Dirk is a Directory Administrator
    When he asks for the available users using the default configuration
    Then he should be presented with following results:
    | page        |  1  |
    | per_page    |  6  |
    | total       |  12 |
    | total_pages |  2  |
    And the matching users should include the following:
    |id | email                   |first_name | last_name | avatar                                 |
    | 1 | george.bluth@reqres.in  | George    | Bluth     | https://reqres.in/img/faces/1-image.jpg|
    | 2 | janet.weaver@reqres.in  | Janet     | Weaver    | https://reqres.in/img/faces/2-image.jpg|
    | 3 | emma.wong@reqres.in     | Emma      | Wong      | https://reqres.in/img/faces/3-image.jpg|
