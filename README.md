# mockito-bytebuddy-freeze
An Example of freezing test in Mockito Inline 2.23.4. Tested in Java 8 and Java 11. 
The identified culprit is [InlineByteBuddyMockMaker](https://github.com/mockito/mockito/blob/release/3.x/src/main/java/org/mockito/internal/creation/bytebuddy/InlineByteBuddyMockMaker.java#L104) - `ByteBuddyAgent.install()` never completes.
