#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/* Copyright 2015 terrestris GmbH & Co. KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ${package};

import org.geotools.process.factory.DescribeParameter;
import org.geotools.process.factory.DescribeProcess;
import org.geotools.process.factory.DescribeResult;
import org.geoserver.wps.gs.GeoServerProcess;
import org.geoserver.wps.process.RawData;
import org.geoserver.wps.process.StringRawData;

/**
 *
 * A simple hello world that uses the (String)RawData class of GeoTools and
 * makes use of some of the metadata properties.
 *
 * @author Nils Bühner
 *
 */
@DescribeProcess(
	title = "extendedHelloWorldWps",
	description = "Extended Hello World WPS Example"
)
public class ExtendedHelloWorldWps implements GeoServerProcess {

	@DescribeResult(
		name = "result",
		description = "The Hello world result string",
		// metadata for the result of the WPS
		// the first mimeType will be the default
		meta = {
			"mimeTypes=text/plain,application/json",
			"chosenMimeType=outputMimeType"
		}
	)
	public RawData execute(
		@DescribeParameter(
			name = "name",
			description = "The name to use in the result",
			min = 1,
			max = 1,
			meta = { "mimeTypes=text/plain" }
		) final String name,

		// This parameter will contain the output mime type the user has chosen.
		// It will NOT appear as a usual parameter in the DescribeProcess of the
		// WPS!
		@DescribeParameter(
			name = "outputMimeType",
			min = 0,
			max = 1
		) final String outputMimeType
	) {

		String helloString = "Hello, " + name + "!";
		String result = "";

		// according to the chosen mime type we will build the result
		if(outputMimeType.equals("application/json")) {
			result = "{\"data\":" + "\"" + helloString + "\"}";
		} else {
			result = helloString;
		}

		return new StringRawData(result, outputMimeType);
	}
}
