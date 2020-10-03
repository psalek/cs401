Testing the Solution
--------------------

We want to test our solution, to verify that the 
relationships shown in the diagram are maintained
during execution.

Note: We have made the aggregation from Transcript
to TranscriptEntry one-way and assume there is
a dependency from Student to Transcript--we treat
Transcript as a computed value, based on the
list of TranscriptEntries.

1. Transcript -> TranscriptEntry:  1 to 0..*.
   - check TranscriptEntry list
   
2. Student -> TranscriptEntry: 1 to 0..*
   - check TranscriptEntry list in Student

3. Section -> TranscriptEntry: 1 to 0..*
   - check TranscriptEntry list in Section
   
4. Maintaining consistency of lists in Section and Student
   - when a Student is added to a section, transcript entry lists must be updated
   - when a section is added to a Student's list of sections, transcript entry lists
   must be updated
   
5. Avoiding duplicate TranscriptEntries:   When we update a Section and Student
with a grade (for some course), if a TranscriptEntry for that student/section
already exists, do not create a new TranscriptEntry (this will be a duplicate) --
just update the existing TranscriptEntry