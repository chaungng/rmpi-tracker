#!/bin/bash
aws cloudformation package  --profile rmpi-tracker-admin --template-file sam.yaml --output-template-file output-sam.yaml --s3-bucket rmpi-tracker-service-cloudformation-package