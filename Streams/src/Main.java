import streams.StreamIntermediateOps;
import streams.StreamTerminalOps;
import streams.StreamVsParallelStream;
import streams.Streams;

public class Main {

  public static void main(String[] args) {
    Streams.createStreams();
    StreamIntermediateOps.ops();
    StreamTerminalOps.ops();
    StreamVsParallelStream.vs();
  }
}