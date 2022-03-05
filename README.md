# Start PostgreSQL database
./gradlew composeUp

# Run application
./gradlew bootRun

# Features
## Create a blog
Sample request:
```shell script
curl --location --request POST 'http://localhost:8080/api/v1/blogs' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Welcome to RealWorld project",
    "content": "See how the exact same Medium.com clone (called Conduit) is built using different frontends and backends. Yes, you can mix and match them, because they all adhere to the same API spec.",
    "tags": [
        "welcome",
        "introduction"
    ]
}'
```

Sample response:
```json
{
    "id": 3,
    "createdAt": "2022-03-05T22:58:15.478"
}
```

## Get all blogs
Sample request:
```shell script
curl --location --request GET 'http://localhost:8080/api/v1/blogs'
```

Sample response:
```json
{
    "blogs": [
        {
            "id": 1,
            "title": "Create a new implementation",
            "content": "Share your knowledge and enpower the community by creating a new implementation",
            "createdAt": "2022-03-05T22:56:58.525",
            "authorId": 1,
            "authorName": "Võ Thành Tài",
            "tags": [
                "implementations"
            ]
        },
        {
            "id": 2,
            "title": "Explore implementations",
            "content": "Over 100 implementations have been created using various languages, libraries, and frameworks. Explore them on CodebaseShow.",
            "createdAt": "2022-03-05T22:57:40.426",
            "authorId": 1,
            "authorName": "Võ Thành Tài",
            "tags": [
                "implementations",
                "codebaseShow"
            ]
        },
        {
            "id": 3,
            "title": "Welcome to RealWorld project",
            "content": "See how the exact same Medium.com clone (called Conduit) is built using different frontends and backends. Yes, you can mix and match them, because they all adhere to the same API spec.",
            "createdAt": "2022-03-05T22:58:15.478",
            "authorId": 1,
            "authorName": "Võ Thành Tài",
            "tags": [
                "welcome",
                "introduction"
            ]
        }
    ]
}
```

## Post a comment
Sample request:
```shell script
curl --location --request POST 'http://localhost:8080/api/v1/blogs/1/comments' \
--header 'Content-Type: application/json' \
--data-raw '{
    "content": "Good blog content"
}'
```

Sample response:
```json
{
    "commentId": 1
}
```

## Get blog's comments
Sample request:
```shell script
curl --location --request GET 'http://localhost:8080/api/v1/blogs/1/comments/'
```

Sample response:
```json
{
    "comments": [
        {
            "commentId": 1,
            "userId": 1,
            "content": "Good blog content"
        }
    ]
}
```