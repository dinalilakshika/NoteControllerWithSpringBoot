package lk.ijse.notecollectorspringbooot.customStatusCodes;


import lk.ijse.notecollectorspringbooot.dto.NoteStatus;
import lk.ijse.notecollectorspringbooot.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus, NoteStatus {
    private int statusCode;
    private String statusMessage;
}
