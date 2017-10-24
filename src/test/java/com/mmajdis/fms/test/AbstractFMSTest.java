package com.mmajdis.fms.test;

import com.mmajdis.fms.FMSApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FMSApplication.class)
@ActiveProfiles("test")
public abstract class AbstractFMSTest {

}
