package de.jmens.mp3wav;

import static de.jmens.mp3wav.Converter.convertFrom;
import static java.nio.file.Files.readAllBytes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.sound.sampled.AudioFormat;
import org.junit.Test;

public class ConverterTest {
	@Test
	public void testConverer() throws Exception {

		final ByteArrayInputStream inputStream = new ByteArrayInputStream(readAllBytes(Paths.get("/tmp/input.mp3")));
		final ByteArrayOutputStream output = new ByteArrayOutputStream();
		final AudioFormat audioFormat = new AudioFormat(44100, 8, 1, true, false);

		convertFrom(inputStream).withFormat(audioFormat).to(output);

		Files.write(Paths.get("/tmp/output.wav"), output.toByteArray());
	}
}
