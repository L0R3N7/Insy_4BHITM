package at.htl.result;

public class ItemHobby {
    Long pCode, hobbyId;

    public ItemHobby(Long pCode, Long hobbyId) {
        this.pCode = pCode;
        this.hobbyId = hobbyId;
    }

    public Long getpCode() {
        return pCode;
    }

    public void setpCode(Long pCode) {
        this.pCode = pCode;
    }

    public Long getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Long hobbyId) {
        this.hobbyId = hobbyId;
    }
}