package info.thecodinglive.photoapp;

import info.thecodinglive.photoapp.storage.FileWriter;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

//@SpringBootTest
//@ExtendWith(SpringExtension.class)
public class DateFormatTest {
    @Test
  void fileWriteGenerateDate() {
        //given
        String expectdDate = FileWriter.dateStr();
        //then
        System.out.println(FileWriter.dateStr());
        Assertions.assertNotNull(expectdDate);
  }
}
