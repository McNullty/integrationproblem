/**
 *
 */
package hr.mladenc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mladenc
 *
 */
@Configuration
@ComponentScan(basePackages = { "hr.mladenc.processor", "hr.mladenc.listener" })
public class ProcessorConfiguration {

}
