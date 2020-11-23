# VACEfron4J
A pure Java™️ api wrapper for [VACEfron's API](https://vacefron.nl/api).
Please note that the client methods may throw IOException's, so handle them appropriately
Json errors are automatically handled

# Examples
```java
// This will return the bytes that have been got from the http request
byte[] heavenBytes = VACEfronClient.heaven("https://cdn.discordapp.com/avatars/326260487220363275/fa5a18f0fe7c1b4692fc2275fd8493a9.png?size=4096");
```

```java
RankcardBuilder builder = new RankcardBuilder();
// Note that this values are for example
Rankcard card = builder
      .setUsername("VACEfron")
      .setAvatar("avatar url")
      .setLevel(5)
      .setRank(5)
      .setCurrentXp(500)
      .setNextLevelXp(1000)
      .setPreviousLevelXp(500)
      // Optional
      .setCustomBackground(BackgroundResolvable.fromColor(Color.BLACK))
      .setXpColor(0xFFFFFF)
      .setBoosting(true)

      .build();
                
byte[] rankcardImage = VACEfronClient.rankcard(card);
```
