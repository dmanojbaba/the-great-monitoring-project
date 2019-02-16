package hello;

public class HelloWorld {

    private final long id;
    private final long time;
    private final String content;

    public HelloWorld(long id, long time, String content) {
        this.id = id;
        this.time = time;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }
}
