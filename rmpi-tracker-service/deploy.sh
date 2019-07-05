#!/bin/bash
aws cloudformation deploy --profile rmpi-tracker-admin --template-file output-sam.yaml --stack-name ServerlessRmpiTrackerService --capabilities CAPABILITY_IAM

