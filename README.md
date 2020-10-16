# timeEntry

### Requirements
> tomcat 8.5.57\
> java8\
> postgresql \
> database username = {your username}\
  database password = {your password}\
  Change these parameters in the postgres.properties\
> Data Base with a name te_bd

### Test TimeEntryRestController (application deployed in application context `timeentry`).
> For windows use `Git Bash`

#### get All entries
`curl -s http://localhost:8080/time_entry/all`

#### get All entries for provided user_id
`curl -s http://localhost:8080/time_entry/?userID=2`

#### get entry by entry_id
`curl -s http://localhost:8080/time_entry/1`

#### delete entries
`curl -s -X DELETE http://localhost:8080/time_entry -d '[{
                                                         "entry_id": 1,
                                                         "source_id": 1,
                                                         "user_id": 1,
                                                         "date": "2015-05-29",
                                                         "hours": 3,
                                                         "tag": "asdf",
                                                         "status": "new"
                                                         },
                                                           {
                                                         "entry_id": 2,
                                                         "source_id": 1,
                                                         "user_id": 2,
                                                         "date": "2015-05-30",
                                                         "hours": 3,
                                                         "tag": "asdf",
                                                         "status": "new"
                                                         }]'`

#### create entry
`curl -s -X POST http://localhost:8080/time_entry -d '{
                                                          "source_id": 6,
                                                          "user_id": 2,
                                                          "date": "2015-05-30",
                                                          "hours": 3,
                                                          "tag": "asdf",
                                                          "status": "new"
                                                        }' -H 'Content-Type:application/json;charset=UTF-8'`

#### update entry with a new status value
`curl -s -X PUT http://localhost:8080/time_entry/1?status=old2 -d '{
                                                                   "entry_id": 1,
                                                                   "source_id": 1,
                                                                   "user_id": 1,
                                                                   "date": "2015-05-29",
                                                                   "hours": 3,
                                                                   "tag": "asdf"
                                                                   }' -H 'Content-Type: application/json'`
