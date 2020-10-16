--Delete existing rows for testing purpose only

DELETE FROM TIME_ENTRIES WHERE EntryID > 0;

INSERT INTO TIME_ENTRIES(EntryID,SourceID,UserID, Date, Hours, Tag) VALUES
             (1,1,1,'2015-05-30', 3, 'asdf'),
             (2,1,2,'2015-05-31', 3, 'asdf'),
             (3,1,2,'2015-05-30', 3, 'asdf');
-- INSERT INTO TIME_ENTRIES(SourceID,UserID, Date, Hours, Tag) VALUES
-- (1,1,'2015-05-30', 3, 'asdf'),
-- (1,2,'2015-05-31', 3, 'asdf'),
-- (1,2,'2015-05-30', 3, 'asdf');