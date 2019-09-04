# mockito-bytebuddy-freeze
An Example of freezing test in Mockito Inline 2.23.4. Tested in Java 8 and Java 11. 

`mvn test` is going to freeze.

The identified culprit is [InlineByteBuddyMockMaker](https://github.com/mockito/mockito/blob/release/3.x/src/main/java/org/mockito/internal/creation/bytebuddy/InlineByteBuddyMockMaker.java#L104) - `ByteBuddyAgent.install()` never completes.

If mockito-inline is skipped the tests don't freeze:

`mvn test -Pwithout-mockito-inline`

## Freezing test

`mvn test -Dtest=FreezingTest`

Freezes because of a static mock field inside static inner class. As soon as this field is removed the test can pass. 

## Fixed freezing test

`mvn test -Dtest=NonFreezingTest`
