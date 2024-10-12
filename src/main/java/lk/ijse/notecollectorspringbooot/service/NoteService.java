package lk.ijse.notecollectorspringbooot.service;


import lk.ijse.notecollectorspringbooot.dto.NoteStatus;
import lk.ijse.notecollectorspringbooot.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteStatus getNote(String noteId);
    void deleteNote(String noteId);
    void updateNote(String noteId, NoteDTO noteDTO);
}
