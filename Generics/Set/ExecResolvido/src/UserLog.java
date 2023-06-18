import java.time.Instant;
import java.util.Objects;

public class UserLog {
    private String username;
    private Instant time;


    public UserLog() {
        this.username = null;
        this.time = null;
    }

    public UserLog(String name, Instant time) {
        this.username = name;
        this.time = time;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public Instant getTime() {
        return this.time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserLog)) {
            return false;
        }
        UserLog userLog = (UserLog) o;
        return Objects.equals(username, userLog.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getUsername() + "'" +
            ", time='" + getTime() + "'" +
            "}";
    }


    
}
